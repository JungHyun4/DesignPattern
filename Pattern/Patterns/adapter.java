package Pattern;

public class adapter implements converter {
    Mathc math = new Mathc();

    public int twiceOf(int num){
        return (int) math.mul(num);
    }
    public int halfOf(int num){
        return (int) math.div(num);
    }
}


class Mathc{

    public float mul(float num){
        return num * 2;
    }

    public float div(float num){
        return num / 2;
    }
}

interface converter{
    public int twiceOf(int num);
    public int halfOf(int num);
}