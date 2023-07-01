/*
 * Jorge González
 * 8-1002-2167
 */

public class Estado {
    private char num[];
    private char noma[];

    public Estado () {
        num   = new char[15];
        noma  = new char[15];
    }

    public void asignar(char[] num, char[] noma) {
        this.num = num;
        this.noma = noma;
    }

    public boolean verificarEstado() {
        boolean resp = true;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != noma[i]) {
                resp = false;
            }
        }
        return resp;
    }

    public char[] getNum() { return num; }
    public char[] getNoma() { return noma; }
}
