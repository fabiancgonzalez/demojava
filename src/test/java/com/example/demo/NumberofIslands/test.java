package com.example.demo.NumberofIslands;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.demo.algortimos.NumberofIslands;

public class test {
@Test
void countsThree(){

    char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };
    int expected = 3;
    int actual = NumberofIslands.countIslands(grid);
    assertEquals(expected, actual);
}

@Test
    void emptyGridReturnsZero() {
        char[][] grid = {};
        int expected = 0;
        int actual = NumberofIslands.countIslands(grid);
        assertEquals(expected, actual);
    }

    @Test
    void allWaterReturnsZero() {
        char[][] grid = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'}
        };
        int expected = 0;
        int actual = NumberofIslands.countIslands(grid);
        assertEquals(expected, actual);
    }

}
