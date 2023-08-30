package org.example.util;

public class RecursionBinaryTree {
    private static String[] branches;
    public static String[] makeBranches(int deph){
        branches = new String[deph];
        int left = 0;
        int right = (int)Math.pow(2, deph) - 1;
        makeBranchesRec(left, right, deph, 0);
        return branches;
    }
    private static void makeBranchesRec(int left, int right, int limit, int deph){
        StringBuilder s  = new StringBuilder((right - left)*2);
        if(branches[deph] != null) s.append(branches[deph]);

        int mid = (left + right) / 2 + 1;

        s.append("-".repeat(mid-left));
        s.append("X");
        s.append("-".repeat(right - mid));
        //s.append(" ");

        branches[deph] = s.toString();

        if (deph + 1 == limit){
            return;
        }
        makeBranchesRec(left, mid-1, limit, deph+1);
        makeBranchesRec(mid, right, limit, deph+1);
    }

}
