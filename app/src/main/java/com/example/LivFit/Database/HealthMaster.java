package com.example.LivFit.Database;

import android.provider.BaseColumns;

public class HealthMaster {
    
    private HealthMaster(){}

    public static class Workout implements BaseColumns{

        public static final String TABLE_NAME="workout";

        public static final String COLUMN_NAME_WORKOUTNAME="workoutname";

        public static final String COLUMN_NAME_CALPMIN="calpmin";

        public static final String COLUMN_NAME_IMAGE="image";

    }

    public static class User implements BaseColumns{

        public static final String TABLE_NAME="user";

        public static final String COLUMN_NAME_USERNAME="username";

        public static final String COLUMN_NAME_PASSWORD="password";

        public static final String COLUMN_NAME_FNAME="fname";

        public static final String COLUMN_NAME_LNAME="lname";

        public static final String COLUMN_NAME_EMAIL="email";

        public static final String COLUMN_NAME_AGE="age";

        public static final String COLUMN_NAME_WEIGHT="weight";

        public static final String COLUMN_NAME_HEIGHT="height";

        public static final String COLUMN_NAME_TARGETWEIGHT="targetweight";

        public static final String COLUMN_NAME_GENDER="gender";

        public static final String COLUMN_NAME_BMI="bmi";

        public static final String COLUMN_NAME_CALGOAL="calgoal";

        public static final String COLUMN_NAME_CALCONSUMPTION="calconsumption";

        public static final String COLUMN_NAME_CALBURNED="calburned";

        public static final String COLUMN_NAME_WATERCOUNT="watercount";

    }

    public static class Meals implements BaseColumns{

        public static final String TABLE_NAME="meals";

        public static final String COLUMN_NAME_MEALNAME="mealname";

        public static final String COLUMN_NAME_CALORIES="calories";

    }

    public static class Nutrition implements BaseColumns{

        public static final String TABLE_NAME="nutrition";

        public static final String COLUMN_NAME_DATE="date";

        public static final String COLUMN_NAME_TOTCAL="totcal";

        public static final String COLUMN_NAME_PROTEIN="protein";

        public static final String COLUMN_NAME_FAT="fat";

        public static final String COLUMN_NAME_CARB="carb";

        public static final String COLUMN_NAME_CHOLESTAROL="cholestarol";

        public static final String COLUMN_NAME_FIBER="fiber";

    }

}
