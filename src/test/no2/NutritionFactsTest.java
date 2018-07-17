package test.no2;

import code.no2.NutritionFacts;

public class NutritionFactsTest {
    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(1,2).calories(3).fat(4)
                .carbohydrate(5).sodium(6).build();
        System.out.println(nutritionFacts);
    }
}
