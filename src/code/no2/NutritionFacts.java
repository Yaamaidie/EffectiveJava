package code.no2;

import java.util.OptionalInt;

//Builder Pattern
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final OptionalInt calories;
    private final OptionalInt fat;
    private final OptionalInt sodium;
    private final OptionalInt carbohydrate;

    public static class Builder {
        //Required parameters
        private final int servingSize;
        private final int servings;

        //optional parameters - initialized to default values
        private OptionalInt calories = OptionalInt.empty();
        private OptionalInt fat = OptionalInt.empty();
        private OptionalInt sodium = OptionalInt.empty();
        private OptionalInt carbohydrate = OptionalInt.empty();

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = OptionalInt.of(val);
            return this;
        }

        public Builder fat(int val) {
            fat = OptionalInt.of(val);
            return this;
        }

        public Builder sodium(int val) {
            sodium = OptionalInt.of(val);
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = OptionalInt.of(val);
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

}
