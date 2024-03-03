package Asignment1;

import java.util.Arrays;
import java.util.Stack;

public class AssembleFloor {
	static boolean largestfloor;
    static boolean flag;

 
	public static void calculateFloors(int[] floorSize) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < floorSize.length; i++) {
            largestfloor = true;
            int floorSize_i = floorSize[i];
            for (int j = i; j < floorSize.length; j++) {
                if (j == i) {
                    continue;
                } else {
                    int floorSize_j = floorSize[j];
                    if (floorSize_i >= floorSize_j) {
                        largestfloor = true;
                        continue;
                    } else {
                        largestfloor = false;
                        stack.push(floorSize_i);
                        break;
                    }
                }
            }

            if (largestfloor == true) {
                    Stack<Integer> stackTemp = displayFloor(stack, floorSize_i, i, floorSize);
                    stack.clear();
                    stack = (Stack<Integer>) stackTemp.clone();
                    stackTemp.clear();
                    System.out.println();
            } else {
                System.out.println("Day " + (i + 1) + " :");
            }
        }
    }

    public static Stack<Integer> displayFloor(Stack<Integer> stack, int currentFloor, int iter, int[] arrayFloor) {

        int[] PopItems = new int[arrayFloor.length];
        int count = 0;

        System.out.print("Day " + (iter + 1) + " : " + currentFloor);
        Stack<Integer> stackTemp = new Stack<Integer>();
        boolean largestSatck;
        if (iter == arrayFloor.length - 1) {
            while (!stack.empty()) {
                int popFloor = (int) stack.pop();
                PopItems[count++] = popFloor;
            }
            if (PopItems != null) {
                Arrays.sort(PopItems);
                for (int i = PopItems.length - 1; i > 0; i--) {
                    if (PopItems[i] != 0) {
                        System.out.print(" " + PopItems[i]);
                    }

                }
            }

            return stackTemp;
        } else {
            if (!stack.empty()) {
                while (!stack.empty()) {
                    largestSatck = true;
                    int popFloor = (int) stack.pop();
                    for (int i = iter; i < arrayFloor.length; i++) {
                        if (i == iter) {
                            continue;
                        }
                        if (popFloor < arrayFloor[i]) {
                            stackTemp.push(popFloor);
                            largestSatck = false;
                            break;
                        } else {
                            largestSatck = true;
                        }
                    }
                    if (largestSatck == true) {
                        PopItems[count++] = popFloor;
                    }
                }
            }
            if (PopItems != null) {
                Arrays.sort(PopItems);
                for (int i = PopItems.length - 1; i > 0; i--) {
                    if (PopItems[i] != 0) {
                        System.out.print(" " + PopItems[i]);
                    }
                }
            }

            return stackTemp;
        }
    }

}
