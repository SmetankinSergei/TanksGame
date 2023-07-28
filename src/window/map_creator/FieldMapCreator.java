package window.map_creator;

import game_objects.bonusBoxes.BigHealthBox;
import game_objects.bonusBoxes.FastBulletBox;
import game_objects.bonusBoxes.SimpleBulletBox;
import game_objects.GameObject;
import game_objects.landscape.*;
import window.ScreenState;
import window.panels.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FieldMapCreator {

    static List<GameObject> list = new ArrayList<>();

    public static List<GameObject> getMap(Stage stage, ScreenState state, int width, int height) {
        stage.setBackground(new Color(166,205,87));
        setBorder(width, height);
        if (state == ScreenState.STAGE_1 || state == ScreenState.STAGE_2 ||
                state == ScreenState.STAGE_3 || state == ScreenState.STAGE_4) {

            lineOfCells(TypeCell.RIVER, TypeLine.DOUBLE_HORIZONTAL, -2, 154, 4);
            lineOfCells(TypeCell.RIVER, TypeLine.DOUBLE_HORIZONTAL, 122, 154, 6);
            lineOfCells(TypeCell.RIVER, TypeLine.DOUBLE_VERTICAL, 202, 194, 15);
            lineOfCells(TypeCell.RIVER, TypeLine.DOUBLE_HORIZONTAL, 242, 454, 20);
            lineOfCells(TypeCell.RIVER, TypeLine.DOUBLE_HORIZONTAL, 686, 454, 11);

            lineOfCells(TypeCell.INDESTRUCTIBLE, TypeLine.VERTICAL, 60, 10, 4);
            lineOfCells(TypeCell.INDESTRUCTIBLE, TypeLine.VERTICAL, 820, 10, 4);

            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 260, 10, 22);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 320, 10, 2);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 320, 95, 18);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 622, 10, 5);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 622, 180, 13);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 686, 10, 22);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 560, 180, 13);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 498, 180, 13);

            lineOfCells(TypeCell.BRICK, TypeLine.HORIZONTAL, 280, 160, 15);
            lineOfCells(TypeCell.BRICK, TypeLine.HORIZONTAL, 280, 10, 21);
            lineOfCells(TypeCell.BRICK, TypeLine.HORIZONTAL, 280, 95, 21);

            lineOfCells(TypeCell.BRICK, TypeLine.HORIZONTAL, 122, 90, 6);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 122, 110, 2);
            lineOfCells(TypeCell.BRICK, TypeLine.DOUBLE_HORIZONTAL, 142, 240, 2);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 122, 200, 4);
            lineOfCells(TypeCell.BRICK, TypeLine.HORIZONTAL, 0, 90, 4);
            lineOfCells(TypeCell.BRICK, TypeLine.HORIZONTAL, 820, 90, 4);
            lineOfCells(TypeCell.BRICK, TypeLine.HORIZONTAL, 410, 640, 4);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 410, 660, 2);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 470, 660, 2);

            lineOfCells(TypeCell.BRICK, TypeLine.HORIZONTAL, 10, 600, 20);
            lineOfCells(TypeCell.BRICK, TypeLine.HORIZONTAL, 490, 600, 20);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 370, 580, 7);
            lineOfCells(TypeCell.BRICK, TypeLine.VERTICAL, 510, 580, 7);

            list.add(new BigHealthBox(147, 115));
            list.add(new SimpleBulletBox(147, 200));
            list.add(new FastBulletBox(647, 32));
            return list;
        }
        return null;
    }

    private static void lineOfCells(TypeCell typeCell, TypeLine typeLine, int startX, int startY, int amountCells) {
        for (int i = 0; i < amountCells; i++) {
            if (typeCell == TypeCell.BRICK) {
                if (typeLine == TypeLine.HORIZONTAL)
                    list.add(new Brick(startX + i * Cell.getCellWidth(), startY));
                if (typeLine == TypeLine.VERTICAL)
                    list.add(new Brick(startX, startY + i * Cell.getCellHeight()));
                if (typeLine == TypeLine.DOUBLE_HORIZONTAL) {
                    list.add(new Brick(startX + i * Cell.getCellWidth(), startY));
                    list.add(new Brick(startX + i * Cell.getCellWidth(), startY + Cell.getCellHeight()));
                }
                if (typeLine == TypeLine.DOUBLE_VERTICAL) {
                    list.add(new Brick(startX, startY + i * Cell.getCellHeight()));
                    list.add(new Brick(startX + Cell.getCellWidth(), startY + i * Cell.getCellHeight()));
                }
            }
            if (typeCell == TypeCell.RIVER) {
                if (typeLine == TypeLine.HORIZONTAL)
                    list.add(new River(startX + i * Cell.getCellWidth(), startY));
                if (typeLine == TypeLine.VERTICAL)
                    list.add(new River(startX, startY + i * Cell.getCellHeight()));
                if (typeLine == TypeLine.DOUBLE_HORIZONTAL) {
                    list.add(new River(startX + i * Cell.getCellWidth(), startY));
                    list.add(new River(startX + i * Cell.getCellWidth(), startY + Cell.getCellHeight()));
                }
                if (typeLine == TypeLine.DOUBLE_VERTICAL) {
                    list.add(new River(startX, startY + i * Cell.getCellHeight()));
                    list.add(new River(startX + Cell.getCellWidth(), startY + i * Cell.getCellHeight()));
                }
            }
            if (typeCell == TypeCell.INDESTRUCTIBLE) {
                if (typeLine == TypeLine.HORIZONTAL)
                    list.add(new Indestructible(startX + i * Cell.getCellWidth(), startY));
                if (typeLine == TypeLine.VERTICAL)
                    list.add(new Indestructible(startX, startY + i * Cell.getCellHeight()));
            }
        }
    }

    private static void setBorder(int width, int height) {
        for (int x = 0; x < width; x += 20) {
            list.add(new Border(x, -20));
            list.add(new Border(x, 700));
        }
        for (int y = 0; y < height; y += 20) {
            list.add(new Border(-20, y));
            list.add(new Border(900, y));
        }
    }
}
