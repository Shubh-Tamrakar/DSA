import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private List<Integer> prefixes;

    public ProductOfNumbers() {
        prefixes = new ArrayList<>();
        prefixes.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefixes = new ArrayList<>();
            prefixes.add(1);
        } else {
            int lastProduct = prefixes.get(prefixes.size() - 1);
            prefixes.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        int n = prefixes.size();
        if (k >= n) {
            return 0;
        }
        return prefixes.get(n - 1) / prefixes.get(n - 1 - k);
    }
}
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */