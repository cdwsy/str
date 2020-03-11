public class UnionFind1 implements uf {
    private int[] id;

    public UnionFind1(int size){
        id=new int[size];
        for (int i=0;i<size;i++){
            id[i]=i;
        }
    }

    private int find(int q){
        if(q < 0 || q>= id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return id[q];
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        for (int i=0;i<id.length;i++){
            if (id[i]==pID){
                id[i]=qID;
            }
        }
    }
}
