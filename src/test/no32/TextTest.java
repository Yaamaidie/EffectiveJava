package test.no32;

import code.no32.Text;

import java.util.EnumSet;

public class TextTest {
    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));
    }
}
