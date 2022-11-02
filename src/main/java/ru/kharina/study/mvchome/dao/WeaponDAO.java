package ru.kharina.study.mvchome.dao;

import org.springframework.stereotype.Component;
import ru.kharina.study.mvchome.models.Weapon;
import ru.kharina.study.mvchome.models.WeaponType;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeaponDAO {
    private List<Weapon> weapons;
    private static int WEAPON_COUNT;

    {
        weapons = new ArrayList<>();

        Weapon w1 = new Weapon("knife");
        w1.setType(WeaponType.EDGED);
        w1.setId(++WEAPON_COUNT);
        weapons.add(w1);

        Weapon w2 = new Weapon("revolver");
        w2.setType(WeaponType.FIREARMS);
        w2.setStorage(100);
        w2.setId(++WEAPON_COUNT);
        weapons.add(w2);

        Weapon w3 = new Weapon("grenade launcher");
        w3.setType(WeaponType.FIREARMS);
        w3.setStorage(10);
        w3.setId(++WEAPON_COUNT);
        weapons.add(w3);
    }

    public List<Weapon> index() {
        return weapons;
    }

    public Weapon show(int id) {
        return weapons.stream().filter(weapon -> weapon.getId() == id).findAny().orElse(null);
    }

    public void save(Weapon weapon) {
        weapon.setId(++WEAPON_COUNT);
        weapons.add(weapon);
    }

    public void update(int id, Weapon weapon) {
        Weapon oldWeapon = show(id);
        oldWeapon.setName(weapon.getName());
        oldWeapon.setStorage(weapon.getStorage());
        oldWeapon.setType(weapon.getType());
    }

    public void delete(int id) {
        weapons.removeIf(w -> w.getId() == id);
    }
}
