package jwangsadinata.github.io.stayintouch.data;

import java.io.Serializable;

/**
 * Created by Jason on 12/12/15.
 */
public class People implements Serializable {

    private String[] students = new String[]{"Joe Koshakow", "Kendell Byrd", "Alex Giese",
                                    "Amanda Yin", "Amyrah Hanah Nadal",
                                    "Andrea Dean", "Audrey Lemberger", "Ben Withbroe", "Camila Volkart",
                                    "Casey Waldren", "Daniel Kang", "Derek Shang", "Dima Smirnov",
                                    "Dylan Baker",
                                    "Elliot Mawby", "Eunice Park",
                                    "Ginny Edelstein", "Hannah Christenson", "Jack Muller",
                                    "Jake Vitale", "Jason Wangsadinata",
                                    "Jeremy Mittleman", "Josh Pitkofsky", "Julie Xia",
                                    "Katie Merin", "Kirsten Baker",
                                    "Laura Griffee",
                                    "Matthew Javaly", "Max Reinisch", "Motorcycle", "Nancy Huang",
                                    "Natalie Melo", "Noam Hurwitz", "Pearson Treanor", "Ross Kruse",
                                    "Sam Neubauer", "Sam Raby", "Sam Boswell", "Tucker Gordon",
                                    "Wanchen Yao", "Will Richards",
                                    "Willie Cohen", "Ziv Epstein", "Zora Yang"};

    private String[] professor = new String[]{"Gyula Y. Katona", "Péter Ekler", "András Recski", "Gábor Bojár", "Daniel Abel",
                                    "András Aszódi", "Katalin Berényi", "György Báron", "András Benczúr",
                                    "István Berta", "Levente Buttyán", "Péter Csermely", "Judit Csima",
                                    "Ernö Duda", "Gergely Fazekas", "Tamás Fleiner", "Katalin Friedl",
                                    "Tamás Hajas", "Gyuri Juhász", "György Kárpáti", "István Lám",
                                    "Márta Magasi", "Zoltán Mann", "István Miklós", "Gergely Palla",
                                    "Péter Pál Pach", "Lóránt Péteri", "Ernö Rubik", "Mariann Schiller",
                                    "István L. Szabó", "Csaba Szalai", "Péter Szeredi", "Dávid Szeszlér",
                                    "László Szécsi", "László Szirmay-Kalos", "Gergely Vass", "Teréz Vincze",
                                    "Mihály Weiner", "Gábor Wiener"};

    private String[] staff = new String[]{"Ákos Kocsány", "Barbara Rotter", "Dorka Szekely", "Greg Borsa", "Reka Bence"};

    public People() {
    }

    public People(String[] students, String[] professor, String[] staff) {
        this.students = students;
        this.professor = professor;
        this.staff = staff;
    }

    public String[] getStudents() {
        return students;
    }


    public String[] getProfessor() {
        return professor;
    }

    public String[] getStaff() {
        return staff;
    }

}
