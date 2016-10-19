/**
 * Created by belows on 16/10/16.
 */

 class Transmogrify {

}

class AlertStatus {
    Status s = null;
    AlertStatus(Status s) {
        this.s = s;
    }

    void setStatus(Status s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s.toString();
    }
}

class Status {}
class Status1 extends  Status {
    @Override
    public String toString() {
        return "Status1";
    }
}

class Status2 extends Status {
    @Override
    public String toString() {
        return "Status2";
    }
}

class Status3 extends Status {
    @Override
    public String toString() {
        return "Status3";
    }
}

public class Ex16 {
    public static void main(String[] args) {
        AlertStatus status = new AlertStatus(new Status1());
        System.out.println(status);
        status.setStatus(new Status2());
        System.out.println(status);
    }
}
