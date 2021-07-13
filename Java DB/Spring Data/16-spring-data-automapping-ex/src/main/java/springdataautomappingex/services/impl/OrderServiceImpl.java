package springdataautomappingex.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataautomappingex.domain.entities.Game;
import springdataautomappingex.domain.entities.Order;
import springdataautomappingex.domain.entities.enums.OrderStatus;
import springdataautomappingex.domain.entities.User;
import springdataautomappingex.repositories.OrderRepository;
import springdataautomappingex.services.GameService;
import springdataautomappingex.services.OrderService;
import springdataautomappingex.services.UserService;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, GameService gameService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.gameService = gameService;
    }


    @Override
    public void addItem(String title) {
        if (this.userService.getUserDto() == null) {
            System.out.println("Only logged in user can add games to cart.");
            return;
        }

        User loggedInUser = this.userService.getLoggedUser();
        Game game = this.gameService.getGameByTitle(title);
        if (game == null) {
            System.out.println("Incorrect game.");
            return;
        }


        if (containsGame(loggedInUser.getGames(), title)) {
            System.out.printf("%s already owns %s.%n", loggedInUser.getFullName(), title);
            return;
        }
        if (loggedInUser.getCurrentOrder() == null) {
            Order currentOrder = new Order();
            currentOrder.setBuyer(loggedInUser);
            currentOrder.getOrderedGames().add(game);
            this.orderRepository.saveAndFlush(currentOrder);
            loggedInUser.setCurrentOrder(currentOrder);
            this.userService.saveUser(loggedInUser);
        }
        else  {
            if (containsGame(loggedInUser.getCurrentOrder().getOrderedGames(), title)) {
                System.out.printf("%s is already in the cart.%n", title);
                return;
            }
            Optional<Order> ownedOrder = findById(loggedInUser.getCurrentOrder().getId());
            if (ownedOrder.isPresent()) {
                ownedOrder.get().getOrderedGames().add(game);
                this.orderRepository.saveAndFlush(ownedOrder.get());
                this.userService.saveUser(loggedInUser);
            }
        }

        System.out.printf("%s added to %s's cart.%n", title, loggedInUser.getFullName());
    }

    @Override
    public Optional<Order> findById(Long id) {
        return this.orderRepository.findById(id);
    }

    @Transactional
    @Override
    public boolean removeItem(String title) {
        if (this.userService.getUserDto() == null) {
            System.out.println("Only logged in user can remove games from cart.");
            return false;
        }

        User loggedInUser = this.userService.getLoggedUser();
        Game game = this.gameService.getGameByTitle(title);
        if (game == null) {
            System.out.println("Incorrect game.");
            return false;
        }

        if (loggedInUser.getCurrentOrder() == null) {
            System.out.println("Cart is empty.");
        } else {
            if (containsGame(loggedInUser.getCurrentOrder().getOrderedGames(), title)) {
                Optional<Order> ownedOrder = findById(loggedInUser.getCurrentOrder().getId());
                    return ownedOrder.get().getOrderedGames().remove(game);

            }
            System.out.printf("%s is not currently in %s's cart.%n", title, loggedInUser.getFullName());
        }
        return false;
    }

    @Transactional
    @Override
    public void buyItem() {
        if (this.userService.getUserDto() == null) {
            System.out.println("Only logged in user can buy games.");
            return;
        }

        User loggedInUser = this.userService.getLoggedUser();

        if (loggedInUser.getCurrentOrder() == null) {
            System.out.println("No games in cart.");
            return;
        }

        loggedInUser.getOrders().stream().filter(order -> order.getOrderStatus().equals(OrderStatus.IN_PROGRESS))
        .findFirst().orElse(null).setOrderStatus(OrderStatus.FINISHED);
        if (!loggedInUser.getCurrentOrder().getOrderedGames().isEmpty()) {
            System.out.println("Successfully bought games:");


            loggedInUser.getCurrentOrder().getOrderedGames().forEach(game -> {
                System.out.println(" -" + game.getTitle());
                loggedInUser.getGames().add(game);
            });
        }
        loggedInUser.setCurrentOrder(null);
    }


    private boolean containsGame(Set<Game> games, String title) {
        if (games==null || games.isEmpty()) {
            return false;
        }
        return games.stream().map(Game::getTitle).collect(Collectors.toList()).contains(title);
    }

}
