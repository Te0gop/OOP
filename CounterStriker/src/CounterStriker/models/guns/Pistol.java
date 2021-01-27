package CounterStriker.models.guns;

public class Pistol extends GunImpl{
    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if(super.getBulletsCount() - 1 < 0) {
            return super.fire();
        }
        super.setBulletsCount(getBulletsCount() - 1);
        return 1;
    }
}
