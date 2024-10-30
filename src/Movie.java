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

        public void setTitle(String title)
        {
            this.title = title;
        }

        public String getDirector()
        {
            return director;
        }

        public void setDirector(String director)
        {
            this.director = director;
        }

        public int getYearCreated()
        {
            return yearCreated;
        }

        public void setYearCreated(int yearCreated)
        {
            this.yearCreated = yearCreated;
        }

        public String getGenre()
        {
            return genre;
        }

        public void setGenre(String genre)
        {
            this.genre = genre;
        }

        public boolean isColor()
        {
            return isColor;
        }

        public void setColor(boolean isColor)
        {
            this.isColor = isColor;
        }

        public int getLengthMinutes()
        {
            return lengthMinutes;
        }

        public void setLengthMinutes(int lengthMinutes)
        {
            this.lengthMinutes = lengthMinutes;
        }

        public String toString()
        {
            return "\nTitle: " + title + "\nDirector: " + director + "\nYear: " + yearCreated + "\nGenre: " + genre + "\nColor: " + (isColor ? "Yes" : "No") + "\nLength: " + lengthMinutes + " minutes";
        }


    }
