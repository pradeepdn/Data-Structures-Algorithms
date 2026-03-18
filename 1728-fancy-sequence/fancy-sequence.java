import java.util.*;

class Fancy {
    private List<Long> values;
    private long totalMult = 1;
    private long totalAdd = 0;
    private static final int MOD = 1_000_000_007;

    public Fancy() {
        values = new ArrayList<>();
    }

    public void append(int val) {
        // We need to store 'val' such that: (stored * totalMult + totalAdd) % MOD == val
        // So: stored = (val - totalAdd) * inverse(totalMult) % MOD
        long inverseMult = power(totalMult, MOD - 2);
        long storedVal = ((val - totalAdd + MOD) % MOD * inverseMult) % MOD;
        values.add(storedVal);
    }

    public void addAll(int inc) {
        totalAdd = (totalAdd + inc) % MOD;
    }

    public void multAll(int m) {
        totalMult = (totalMult * m) % MOD;
        totalAdd = (totalAdd * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= values.size()) return -1;
        // Apply current transformation: (stored * totalMult + totalAdd) % MOD
        long result = (values.get(idx) * totalMult) % MOD;
        result = (result + totalAdd) % MOD;
        return (int) result;
    }

    // Fast Power Algorithm for Modular Inverse
    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}