package weapon;

public abstract class Weapon {
    protected String name;
    protected String cartridge;
    protected String actionType;

    public String assemble() {
        return name + " assembled";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCartridge() {
        return cartridge;
    }

    public void setCartridge(String cartridge) {
        this.cartridge = cartridge;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
}
