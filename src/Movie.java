public class Movie
    {
        private String title;
        private String director;
        private int yearCreated;
        private String genre;
        private boolean isColor;
        private int lengthMinutes;

        public Movie(String title, String director, int yearCreated, String genre, boolean isColor, int lengthMinutes)
        {
            this.title = title;
            this.director = director;
            this.yearCreated = yearCreated;
            this.genre = genre;
            this.isColor = isColor;
            this.lengthMinutes = lengthMinutes;
        }

        public String getTitle()
        {
            return title;
        }

        public String getDirector()
        {
            return director;
        }

        public int getYearCreated()
        {
            return yearCreated;
        }

        public String getGenre()
        {
            return genre;
        }

        public boolean isColor()
        {
            return isColor;
        }

        public int getLnegthMinutes()
        {
            return lengthMinutes;
        }

        public String toString()
        {
            return "Title: " + title + "\nDirector: " + director + "\nYear: " + yearCreated + "\nGenre: " + genre + "\nColor: " + (isColor ? "Yes" : "No") + "\nLength: " + lengthMinutes + " minutes";
        }


    }
