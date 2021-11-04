package com.example.battleships.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BattleBindingModel {
    private String attackerShipName;
    private String defenderShipName;

    public BattleBindingModel() {
    }


    public String getAttackerShipName() {
        return attackerShipName;
    }

    public BattleBindingModel setAttackerShipName(String attackerShipName) {
        this.attackerShipName = attackerShipName;
        return this;
    }


    public String getDefenderShipName() {
        return defenderShipName;
    }

    public BattleBindingModel setDefenderShipName(String defenderShipName) {
        this.defenderShipName = defenderShipName;
        return this;
    }
}
