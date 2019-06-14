package com.appventurez.project404.utility;



import java.util.ArrayList;
import java.util.List;

public class DummyDataGenerator {


    public static List<String> getDummyStringList(int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i + "");
        }
        return list;
    }

//
//    public static List<RatingModel> getRatingList() {
//        List<RatingModel> dummyLangs = new ArrayList<>();
//        dummyLangs.add(new RatingModel("Lava","https://www.tripadvisor.com/UserReviewEdit-g294009-d1986638-Lava_Lounge-Doha.html"));
//        dummyLangs.add(new RatingModel("Manko Doha","https://www.tripadvisor.com/UserReviewEdit-g294009-d15273211-Manko_Doha-Doha.html"));
//        dummyLangs.add(new RatingModel("Gemmayze","https://www.tripadvisor.com/UserReviewEdit-g294009-d14078677-Gemmayze-Doha.html"));
//        dummyLangs.add(new RatingModel("Belgian Café","https://www.tripadvisor.com/UserReviewEdit-g294009-d1979138-Belgian_Cafe-Doha.html"));
//        dummyLangs.add(new RatingModel("Coral","https://www.tripadvisor.com/UserReviewEdit-g294009-d1986640-Coral_All_Day_Dining-Doha.html"));
//        dummyLangs.add(new RatingModel("Paloma","https://www.tripadvisor.com/UserReviewEdit-g294009-d1986664-Paloma-Doha.html"));
//        dummyLangs.add(new RatingModel("Mykonos","https://www.tripadvisor.com/UserReviewEdit-g294009-d1599757-Mykonos-Doha.html"));
//
//        dummyLangs.add(new RatingModel("La Mar Doha by Gastón Acurio","https://www.tripadvisor.com/UserReviewEdit-g294009-d15273210-La_Mar_Doha-Doha.html"));
//        dummyLangs.add(new RatingModel("Tea Lounge","https://www.tripadvisor.com/UserReviewEdit-g294009-d1986712-Tea_Lounge-Doha.html"));
//        dummyLangs.add(new RatingModel("Pool Bar","https://www.tripadvisor.com/UserReviewEdit-g294009-d10623168-InterContinental_Doha_Residences-Doha.html"));
//
//
//        return dummyLangs;
//    }


    public static List<String> getDummyDateList() {
        List<String> dummyLangs = new ArrayList<>();
        dummyLangs.add("Nov,26 2018");
        dummyLangs.add("Nov,27 2018");
        dummyLangs.add("Nov,28 2018");
        return dummyLangs;
    }

    public static List<String> getDummyRefCodeList() {
        List<String> dummyLangs = new ArrayList<>();
        dummyLangs.add("7000CB");
        dummyLangs.add("8001CB");
        dummyLangs.add("9002CB");
        return dummyLangs;
    }


    public static List<String> getDummyAmountList() {
        List<String> dummyLangs = new ArrayList<>();
        dummyLangs.add("1000");
        dummyLangs.add("2000");
        dummyLangs.add("3000");
        return dummyLangs;
    }




   /* public static List<TimeData> getDummyData()
    {
        List<TimeData> dummytimes = new ArrayList<>();
        dummytimes.add(new TimeData("07:00:00",0));
        dummytimes.add(new TimeData("07:05:00",0));
        dummytimes.add(new TimeData("07:10:00",0));
        dummytimes.add(new TimeData("07:15:00",0));
        dummytimes.add(new TimeData("07:20:00",0));
        dummytimes.add(new TimeData("07:25:00",0));
        dummytimes.add(new TimeData("07:30:00",1));
        dummytimes.add(new TimeData("07:35:00",1));
        dummytimes.add(new TimeData("07:40:00",1));
        dummytimes.add(new TimeData("07:45:00",1));
        dummytimes.add(new TimeData("07:50:00",1));
        dummytimes.add(new TimeData("07:55:00",1));

        dummytimes.add(new TimeData("08:00:00",2));
        dummytimes.add(new TimeData("07:05:00",2));
        dummytimes.add(new TimeData("07:10:00",2));
        dummytimes.add(new TimeData("07:15:00",2));
        dummytimes.add(new TimeData("07:20:00",2));
        dummytimes.add(new TimeData("07:25:00",2));
        dummytimes.add(new TimeData("07:30:00",3));
        dummytimes.add(new TimeData("07:35:00",3));
        dummytimes.add(new TimeData("07:40:00",3));
        dummytimes.add(new TimeData("07:45:00",3));
        dummytimes.add(new TimeData("07:50:00",3));
        dummytimes.add(new TimeData("07:55:00",3));


        dummytimes.add(new TimeData("09:00:00",4));
        dummytimes.add(new TimeData("09:05:00",4));
        dummytimes.add(new TimeData("09:10:00",4));
        dummytimes.add(new TimeData("09:15:00",4));
        dummytimes.add(new TimeData("09:20:00",4));
        dummytimes.add(new TimeData("09:25:00",4));
        dummytimes.add(new TimeData("09:30:00",5));
        dummytimes.add(new TimeData("09:35:00",5));
        dummytimes.add(new TimeData("09:40:00",5));
        dummytimes.add(new TimeData("09:45:00",5));
        dummytimes.add(new TimeData("09:50:00",5));
        dummytimes.add(new TimeData("09:55:00",5));

        dummytimes.add(new TimeData("10:00:00",6));
        dummytimes.add(new TimeData("10:05:00",6));
        dummytimes.add(new TimeData("10:10:00",6));
        dummytimes.add(new TimeData("10:15:00",6));
        dummytimes.add(new TimeData("10:20:00",6));
        dummytimes.add(new TimeData("10:25:00",6));
        dummytimes.add(new TimeData("10:30:00",7));
        dummytimes.add(new TimeData("10:35:00",7));
        dummytimes.add(new TimeData("10:40:00",7));
        dummytimes.add(new TimeData("10:45:00",7));
        dummytimes.add(new TimeData("10:50:00",7));
        dummytimes.add(new TimeData("10:55:00",7));


        dummytimes.add(new TimeData("11:00:00",8));
        dummytimes.add(new TimeData("11:05:00",8));
        dummytimes.add(new TimeData("11:10:00",8));
        dummytimes.add(new TimeData("11:15:00",8));
        dummytimes.add(new TimeData("11:20:00",8));
        dummytimes.add(new TimeData("11:25:00",8));
        dummytimes.add(new TimeData("11:30:00",9));
        dummytimes.add(new TimeData("11:35:00",9));
        dummytimes.add(new TimeData("11:40:00",9));
        dummytimes.add(new TimeData("11:45:00",9));
        dummytimes.add(new TimeData("11:50:00",9));
        dummytimes.add(new TimeData("11:55:00",9));


        dummytimes.add(new TimeData("12:00:00",10));
        dummytimes.add(new TimeData("12:05:00",10));
        dummytimes.add(new TimeData("12:10:00",10));
        dummytimes.add(new TimeData("12:15:00",10));
        dummytimes.add(new TimeData("12:20:00",10));
        dummytimes.add(new TimeData("12:25:00",10));
        dummytimes.add(new TimeData("12:30:00",11));
        dummytimes.add(new TimeData("12:35:00",11));
        dummytimes.add(new TimeData("12:40:00",11));
        dummytimes.add(new TimeData("12:45:00",11));
        dummytimes.add(new TimeData("12:50:00",12));
        dummytimes.add(new TimeData("12:55:00",12));


        dummytimes.add(new TimeData("13:00:00",12));
        dummytimes.add(new TimeData("13:05:00",12));
        dummytimes.add(new TimeData("13:10:00",12));
        dummytimes.add(new TimeData("13:15:00",12));
        dummytimes.add(new TimeData("13:20:00",12));
        dummytimes.add(new TimeData("13:25:00",12));
        dummytimes.add(new TimeData("13:30:00",13));
        dummytimes.add(new TimeData("13:35:00",13));
        dummytimes.add(new TimeData("13:40:00",13));
        dummytimes.add(new TimeData("13:45:00",13));
        dummytimes.add(new TimeData("13:50:00",13));
        dummytimes.add(new TimeData("13:55:00",13));

        dummytimes.add(new TimeData("14:00:00",14));
        dummytimes.add(new TimeData("14:05:00",14));
        dummytimes.add(new TimeData("14:10:00",14));
        dummytimes.add(new TimeData("14:15:00",14));
        dummytimes.add(new TimeData("14:20:00",14));
        dummytimes.add(new TimeData("14:25:00",14));
        dummytimes.add(new TimeData("14:30:00",15));
        dummytimes.add(new TimeData("14:35:00",15));
        dummytimes.add(new TimeData("14:40:00",15));
        dummytimes.add(new TimeData("14:45:00",15));
        dummytimes.add(new TimeData("14:50:00",15));
        dummytimes.add(new TimeData("14:55:00",15));

        dummytimes.add(new TimeData("15:00:00",16));
        dummytimes.add(new TimeData("15:05:00",16));
        dummytimes.add(new TimeData("15:10:00",16));
        dummytimes.add(new TimeData("15:15:00",16));
        dummytimes.add(new TimeData("15:20:00",16));
        dummytimes.add(new TimeData("15:25:00",16));
        dummytimes.add(new TimeData("15:30:00",17));
        dummytimes.add(new TimeData("15:35:00",17));
        dummytimes.add(new TimeData("15:40:00",17));
        dummytimes.add(new TimeData("15:45:00",17));
        dummytimes.add(new TimeData("15:50:00",17));
        dummytimes.add(new TimeData("15:55:00",17));


        dummytimes.add(new TimeData("16:00:00",18));
        dummytimes.add(new TimeData("16:05:00",18));
        dummytimes.add(new TimeData("16:10:00",18));
        dummytimes.add(new TimeData("16:15:00",18));
        dummytimes.add(new TimeData("16:20:00",18));
        dummytimes.add(new TimeData("16:25:00",18));
        dummytimes.add(new TimeData("16:30:00",19));
        dummytimes.add(new TimeData("16:35:00",19));
        dummytimes.add(new TimeData("16:40:00",19));
        dummytimes.add(new TimeData("16:45:00",19));
        dummytimes.add(new TimeData("16:50:00",19));
        dummytimes.add(new TimeData("16:55:00",19));

        dummytimes.add(new TimeData("17:00:00",20));
        dummytimes.add(new TimeData("17:05:00",20));
        dummytimes.add(new TimeData("17:10:00",20));
        dummytimes.add(new TimeData("17:15:00",20));
        dummytimes.add(new TimeData("17:20:00",20));
        dummytimes.add(new TimeData("17:25:00",20));
        dummytimes.add(new TimeData("17:30:00",20));
        dummytimes.add(new TimeData("17:35:00",21));
        dummytimes.add(new TimeData("17:40:00",21));
        dummytimes.add(new TimeData("17:45:00",21));
        dummytimes.add(new TimeData("17:50:00",21));
        dummytimes.add(new TimeData("17:55:00",21));

        dummytimes.add(new TimeData("18:00:00",22));
        dummytimes.add(new TimeData("18:05:00",22));
        dummytimes.add(new TimeData("18:10:00",22));
        dummytimes.add(new TimeData("18:15:00",22));
        dummytimes.add(new TimeData("18:20:00",22));
        dummytimes.add(new TimeData("18:25:00",22));
        dummytimes.add(new TimeData("18:30:00",23));
        dummytimes.add(new TimeData("18:35:00",23));
        dummytimes.add(new TimeData("18:40:00",23));
        dummytimes.add(new TimeData("18:45:00",23));
        dummytimes.add(new TimeData("18:50:00",23));
        dummytimes.add(new TimeData("18:55:00",23));


        dummytimes.add(new TimeData("19:00:00",24));
        dummytimes.add(new TimeData("19:05:00",24));
        dummytimes.add(new TimeData("19:10:00",24));
        dummytimes.add(new TimeData("19:15:00",24));
        dummytimes.add(new TimeData("19:20:00",24));
        dummytimes.add(new TimeData("19:25:00",24));
        dummytimes.add(new TimeData("19:30:00",25));
        dummytimes.add(new TimeData("19:35:00",25));
        dummytimes.add(new TimeData("19:40:00",25));
        dummytimes.add(new TimeData("19:45:00",25));
        dummytimes.add(new TimeData("19:50:00",25));
        dummytimes.add(new TimeData("19:55:00",25));

        dummytimes.add(new TimeData("20:00:00",26));
        dummytimes.add(new TimeData("20:05:00",26));
        dummytimes.add(new TimeData("20:10:00",26));
        dummytimes.add(new TimeData("20:15:00",26));
        dummytimes.add(new TimeData("20:20:00",26));
        dummytimes.add(new TimeData("20:25:00",26));
        dummytimes.add(new TimeData("20:30:00",27));
        dummytimes.add(new TimeData("20:35:00",27));
        dummytimes.add(new TimeData("20:40:00",27));
        dummytimes.add(new TimeData("20:45:00",27));
        dummytimes.add(new TimeData("20:50:00",27));
        dummytimes.add(new TimeData("20:55:00",27));

        dummytimes.add(new TimeData("21:00:00",28));
        dummytimes.add(new TimeData("21:05:00",28));
        dummytimes.add(new TimeData("21:10:00",28));
        dummytimes.add(new TimeData("21:15:00",28));
        dummytimes.add(new TimeData("21:20:00",28));
        dummytimes.add(new TimeData("21:25:00",28));
        dummytimes.add(new TimeData("21:30:00",29));
        dummytimes.add(new TimeData("21:35:00",29));
        dummytimes.add(new TimeData("21:40:00",29));
        dummytimes.add(new TimeData("21:45:00",29));
        dummytimes.add(new TimeData("21:50:00",29));
        dummytimes.add(new TimeData("21:55:00",29));

        dummytimes.add(new TimeData("22:00:00",30));
        dummytimes.add(new TimeData("22:05:00",30));
        dummytimes.add(new TimeData("22:10:00",30));
        dummytimes.add(new TimeData("22:15:00",30));
        dummytimes.add(new TimeData("22:20:00",30));
        dummytimes.add(new TimeData("22:25:00",30));
        dummytimes.add(new TimeData("22:30:00",31));
        dummytimes.add(new TimeData("22:35:00",31));
        dummytimes.add(new TimeData("22:40:00",31));
        dummytimes.add(new TimeData("22:45:00",31));
        dummytimes.add(new TimeData("22:50:00",31));
        dummytimes.add(new TimeData("22:55:00",31));






        return dummytimes;

    }



    public static ArrayList<RespComCl.CompetencyChecklistNoBean> getDummyComData() {
        ArrayList<RespComCl.CompetencyChecklistNoBean> dummytimes = new ArrayList<>();

        for (int i = 0; i < 27; i++) {
            RespComCl.CompetencyChecklistNoBean competencyChecklistNoBean=new RespComCl.CompetencyChecklistNoBean();
            competencyChecklistNoBean.setValue("Y");
            competencyChecklistNoBean.setId(""+i);
            competencyChecklistNoBean.setName("Name"+i);
            dummytimes.add(competencyChecklistNoBean);

        }

        return dummytimes;
    }*/

    }
