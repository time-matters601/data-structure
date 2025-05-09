package com.example.arraysdemo.service;

import org.springframework.stereotype.Service;
import java.util.Map;
@Service
public class ArrayService {

    // 1D Array: Find maximum temperature
            public int findMaxTemperature (int[] temperatures) {
                if (temperatures == null || temperatures.length == 0){
                    throw new IllegalArgumentException("Temperature array cannot be empty");

                }
                int max = temperatures[0];
                for (int temp : temperatures) {
                    if (temp > max){
                        max=temp;
                    }
                }
                return max;
            }


// 1D Array: Calculate average
public double calculateAverage(int[] numbers){
    if (numbers == null || numbers.length == 0) {

        throw new IllegalArgumentException("Number array cannot be empty");
    }

    int sum = 0;
    for (int num : numbers){
        sum += num;
    }
    return (double) sum / numbers.length;
}
// 2D Array: Matrix multiplication
public int[][] multiplyMatrices(int[][] matrixA, int [][]matrixB){
    if (matrixA[0].length != matrixB.length){
        throw new IllegalArgumentException("Matrix dimenssions don't match for multiplication");
    }
    int[][]result = new int[matrixA.length][matrixB[0].length];

    for (int i = 0; i < matrixA.length; i++) {
        for (int j = 0; j < matrixB.length; j++) {
            for (int k = 0; k < matrixA[i].length; k++) {
                result[i][j] += matrixA[i][k] * matrixB[k][j];
            }
        }
    }
    return result;
}

//2D Array: image rotation (90 degrees clockwise)
public int[][] rotateImage(int[][] image) {
    int n = image.length;
    int[][] rotated = new int[n][n];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            rotated[j][n - 1 - i] = image[i][j];
        }
    }
    return rotated;
}

    public Object analyzeTemperatures(double[] temperatures) {
                if( temperatures == null || temperatures.length == 0){
                    throw new IllegalArgumentException("Temperature array cannot be empty");
                }

                double max = temperatures[0];
                double min = temperatures[0];
                double sum = 0;

                for (double temp : temperatures) {
                    if (temp > max){
                        max=temp;
                    }
                    if (temp < min){
                        min=temp;

                    }
                    sum += temp;
                }

                double average = sum / temperatures.length;

                return Map.of(
                        "max", max,
                        "min", min,
                        "average", average
                );
    }
// transpose matrix methode
    public int[][] transposeMatrix(int[][] matrix) {
                if (matrix == null || matrix.length == 0){
                    throw new IllegalArgumentException("Matrix cannot be empty");
                }

                int rows = matrix.length;
                int cols = matrix[0].length;
                int[][]transposed = new int [cols][rows];

                for (int i=0; i<rows; i++) {
                    for(int j=0; j <cols; j++){
                        transposed[j][i]= matrix [i][j];
                    }
                }

                return transposed;
    }
}