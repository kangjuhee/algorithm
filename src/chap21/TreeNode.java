package chap21;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    private Fortress fortress = null;
    private TreeNode parent = null;
    private List<TreeNode> children = new ArrayList<>();

    public TreeNode(Fortress fortress) {
        this.fortress = fortress;
    }

    public Fortress getFortress() {
        return fortress;
    }

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setFortress(Fortress fortress) {
        this.fortress = fortress;
    }

    public void setParent(TreeNode node) {
        this.parent = node;
    }

    public void addChild(TreeNode node) {
        children.add(node);
    }

    public Boolean hasChild() {
        if (children.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean hasParent() {
        // parent가 null로 초기화되어 있었기 때문에 parent.equals(null)로
        // null 체크를 하게되면 NullPointerException이 발생한다.
        if (parent == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        String str = "xPos : " + this.getFortress().getXpos() + " yPos : " + this.getFortress().getYpos()
                + " radius : " + this.getFortress().getRadius();
        return str;
    }
}
