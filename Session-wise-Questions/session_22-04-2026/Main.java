public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);

        System.out.println(st.query(1, 3)); // sum from index 1 to 3 → 3+5+7 = 15

        st.update(1, 10); // arr[1] = 10

        System.out.println(st.query(1, 3)); // now → 10+5+7 = 22
    }

    static class SegmentTree {
        int[] tree;
        int[] arr;
        int n;

        SegmentTree(int[] initArray) {
            this.arr = initArray;
            this.n = arr.length;
            this.tree = new int[4 * n];
            build(0, 0, n - 1);
        }
        private void build(int index, int l, int r) {
            if (l == r) {
                tree[index] = arr[l];
                return;
            }

            int mid = l + (r - l) / 2;

            build(2 * index + 1, l, mid);
            build(2 * index + 2, mid + 1, r);

            tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
        }
        public int query(int ql, int qr) {
            return query(0, 0, n - 1, ql, qr);
        }

        private int query(int index, int l, int r, int ql, int qr) {
            if (r < ql || l > qr) return 0;
            if (l >= ql && r <= qr) return tree[index];
            int mid = l + (r - l) / 2;
            int left = query(2 * index + 1, l, mid, ql, qr);
            int right = query(2 * index + 2, mid + 1, r, ql, qr);

            return left + right;
        }
        public void update(int pos, int val) {
            update(0, 0, n - 1, pos, val);
        }

        private void update(int index, int l, int r, int pos, int val) {
            if (l == r) {
                tree[index] = val;
                return;
            }
            int mid = l + (r - l) / 2;

            if (pos <= mid) {
                update(2 * index + 1, l, mid, pos, val);
            } else {
                update(2 * index + 2, mid + 1, r, pos, val);
            }

            tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
        }
    }
}