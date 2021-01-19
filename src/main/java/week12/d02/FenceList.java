package week12.d02;

public class FenceList {

    private final Fence fence;
    private final int numberOfSite;

    public FenceList(Fence fence, int numberOfSite) {
        this.fence = fence;
        this.numberOfSite = numberOfSite;
    }

    public Fence getFence() {
        return fence;
    }

    public int getNumberOfSite() {
        return numberOfSite;
    }

}
