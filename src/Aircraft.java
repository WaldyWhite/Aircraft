public class Aircraft {
    private int x, y, z, fuel, countBombs;
    private int dir = 0;
    private boolean printReq = true;

    public Aircraft() {
        this.x = 100;
        this.y = 100;
        this.z = 100;
        this.fuel = 100;
        this.countBombs = 5;
    }

    public Aircraft(int x, int y, int z, int fuel, int countBombs) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.fuel = fuel;
        this.countBombs = countBombs;
    }

    public void flyStraight(int straight) {
        switch (dir) {
            case 0:
                this.x += straight;
                break;
            case 1:
                this.y -= straight;
                break;
            case 2:
                this.x -= straight;
                break;
            case 3:
                this.y += straight;
                break;
            default:
                System.out.println("Что то пошло не так");
                break;
        }
        fuel--;
        String toPrint = String.format(
                "Вы пролетели прямо и сейчас находитесь на координатах: x = %d, y = %d, z = %d. Топлива осталось = %d",
                this.x, this.y, this.z, this.fuel
        );
        if (fuel <= 0) {
            System.out.println("Кончилось топливо(. Игра окончена");
        } else if (this.printReq){
            System.out.println(toPrint);
        }
    }

    public void flyUp(int up, int straight) {
        this.printReq = false;
        flyStraight(straight);
        this.z += up;
        String toPrint = String.format(
                "Вы поднялись ввысь и сейчас находитесь на координатах: x = %d, y = %d, z = %d. Топлива осталось = %d",
                x, y, z, fuel
        );
        if (fuel <= 0) {
            System.out.println("Кончилось топливо(. Игра окончена");
        } else if (!this.printReq){
            System.out.println(toPrint);
        }
        this.printReq = true;
    }

    public void flyDown(int down, int straight) {
        this.printReq = false;
        flyStraight(straight);
        this.z -= down;
        String toPrint = String.format(
                "Вы опустились ниже и сейчас находитесь на координатах: x = %d, y = %d, z = %d. Топлива осталось = %d",
                x, y, z, fuel
        );
        if (z <= 0) {
            this.z = 0;
            System.out.println("Самолет приземлился.");
        } else if (!this.printReq){
            System.out.println(toPrint);
        }
        this.printReq = true;
    }

    public void turnRight() {
        String toPrint = "Вы повернули направо";
        dir++;
        if (dir == 4) {
            dir = 0;
        }
        System.out.println(toPrint);
    }

    public void turnLeft() {
        dir--;
        if (dir == -1) {
            dir = 3;
        }
        System.out.println("Вы повернули налево");
    }

    public void dropBombs() {
        if (countBombs > 0) {
            countBombs--;
            System.out.println("Самолет сбросил бомбы по координатам x = " + this.x + ", y = " + this.y + ". Кол-во бомб = " + this.countBombs);
        } else {
            System.out.println("Нет ни одной бомбы");        }
    }

    public void fillFuel() {
        if (z != 0) {
            System.out.println("Нельзя заправляться в воздухе");
        } else {
            this.fuel = 100;
            this.countBombs = 5;
            System.out.println("Вы заправились. Сейчас топлива = " + this.fuel + ", Кол-во бомб " + this.countBombs);
        }

    }
}