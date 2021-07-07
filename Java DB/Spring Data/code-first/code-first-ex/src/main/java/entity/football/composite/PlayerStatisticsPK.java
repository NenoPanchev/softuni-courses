package entity.football.composite;

import java.io.Serializable;
import java.util.Objects;

public class PlayerStatisticsPK implements Serializable {
    private Long gameId;
    private Long playerId;

    public PlayerStatisticsPK(Long gameId, Long playerId) {
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public PlayerStatisticsPK() {
    }

    public Long getGameId() {
        return gameId;
    }

    public PlayerStatisticsPK setGameId(Long gameId) {
        this.gameId = gameId;
        return this;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public PlayerStatisticsPK setPlayerId(Long playerId) {
        this.playerId = playerId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStatisticsPK that = (PlayerStatisticsPK) o;
        return Objects.equals(gameId, that.gameId) && Objects.equals(playerId, that.playerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, playerId);
    }
}
