package Utils;

public enum Messages {

    CONNECTCLIENT1((byte)1),
    CONNECTCLIENT2((byte)2),

    CONNECTSERVER((byte) 3),
    FINISH((byte)4);


    private final byte value;

    Messages(byte value){
        this.value = value;
    }

    public byte getValue(){
        return  value;
    }

    public String getValueString() {
        return  String.valueOf(value);
    }

}
