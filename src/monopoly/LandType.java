package monopoly;

public class LandType {
    static LandType getTypeByNum(int typeNum) {
        if (typeNum == 1) {
            return new TypeOne();
        }
        else if (typeNum == 2) {
            return new TypeTwo();
        }
        else {
            return new TypeThree();
        }
    }

    int getTypePrice() {
        return 0;
    }
}
