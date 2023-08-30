package org.example.util;

//1)Если в какой-то момент суммарный вес всех выбранных предметов достигнет
//целевого, работа завершена.
//2)Выбрать первый предмет. Общий вес остальных предметов должен быть равен
//разности между целевым весом рюкзака и весом первого предмета; эта разность
//становится новым целевым весом.
//3)Последовательно перебрать все комбинации остальных предметов. Впрочем,
//перебирать все без исключения комбинации не обязательно — если суммарный вес предметов превышает целевой,
//добавление новых предметов можно прекратить
//4)Если ни одна из комбинаций не сработала, отложить первый предмет и повторить весь процесс для второго
//5)Продолжить с третьим предметом и т. д., пока не будут проверены все комбинации.
// После завершения перебора можно быть уверенным в том, что решения
//не существует.

import java.util.ArrayList;
import java.util.List;

public class BackpackProblem {
    public static boolean backpackProblem(int[] weights, int target){
        return backpackProblemRec(weights, target, 0, 0);
    }
    private static List<List<Integer>> result;
    public static List<List<Integer>> backpackProblemGetList(int[] candidates, int target){
        result = new ArrayList<>(150);
        backpackProblemGetListRec(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private static void backpackProblemGetListRec(int[] candidates, int target, int currentSum, List<Integer> values){
        for(int i = 0; i < candidates.length; i++){
            if(currentSum + candidates[i] == target){
                List<Integer> subResult = new ArrayList<>(values);
                subResult.add(candidates[i]);
                result.add(subResult);
            }
            else if(currentSum + candidates[i] > target){
                continue;
            }
            else{
                List<Integer> listToSend = new ArrayList<>(values);
                listToSend.add(candidates[i]);
                backpackProblemGetListRec(candidates, target, currentSum + candidates[i], listToSend);
            }
        }
    }
    private static boolean backpackProblemRec(int[] weights, int target, int start, int currentSum){
        if(currentSum > target){
            return false;
        }
        for(int i = start; i < weights.length; i++){
            int newCurrentSum = currentSum + weights[i];
            if(newCurrentSum == target){
                return true;
            }
            else{
                boolean res = backpackProblemRec(weights, target, i+1, newCurrentSum);
                if(res) return res;
            }
        }
        return false;
    }
}
