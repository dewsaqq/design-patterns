package visitor;

import weapon.Weapon;

public interface Visitor {
    void visit(Weapon weapon);
}
