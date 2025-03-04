
package be4rjp.sclat.manager;

import static be4rjp.sclat.Main.conf;
import be4rjp.sclat.data.DataMgr;
import be4rjp.sclat.data.MainWeapon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Be4rJP
 */
public class MainWeaponMgr {
    public synchronized static void SetupMainWeapon(){
        for (String weaponname : conf.getWeaponConfig().getConfigurationSection("MainWeapon").getKeys(false)){
            String WeaponType = conf.getWeaponConfig().getString("MainWeapon." + weaponname + ".WeaponType");
            Material WeaponMaterial = Material.getMaterial(conf.getWeaponConfig().getString("MainWeapon." + weaponname + ".WeaponMaterial"));
            double random = conf.getWeaponConfig().getDouble("MainWeapon." + weaponname + ".ShootRandom");
            int distick = conf.getWeaponConfig().getInt("MainWeapon." + weaponname + ".ShootDistance");
            double shootspeed = conf.getWeaponConfig().getDouble("MainWeapon." + weaponname + ".ShootSpeed");
            int shoottick = conf.getWeaponConfig().getInt("MainWeapon." + weaponname + ".ShootTick");
            int paintrandom = conf.getWeaponConfig().getInt("MainWeapon." + weaponname + ".PaintRandom");
            int maxpaintdis = conf.getWeaponConfig().getInt("MainWeapon." + weaponname + ".MaxPaintDistance");
            float needink = (float)conf.getWeaponConfig().getDouble("MainWeapon." + weaponname + ".NeedInk");
            double damage = conf.getWeaponConfig().getDouble("MainWeapon." + weaponname + ".Damage");
            
            MainWeapon mw = new MainWeapon(weaponname);
            mw.setWeaponType(WeaponType);
            ItemStack is = new ItemStack(WeaponMaterial);
            ItemMeta itemMeta = is.getItemMeta();
            itemMeta.setDisplayName(weaponname);
            is.setItemMeta(itemMeta);
            mw.setWeaponItemStack(is);
            mw.setRandom(random);
            mw.setDistanceTick(distick);
            mw.setShootSpeed(shootspeed);
            mw.setShootTick(shoottick);
            mw.setPaintRandom(paintrandom);
            mw.setMaxPaintDis(maxpaintdis);
            mw.setNeedInk(needink);
            mw.setDamage(damage);
            DataMgr.setMainWeapon(weaponname, mw);
        }
    }
}
