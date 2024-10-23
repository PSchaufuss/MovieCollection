public class Movie
    {
        private String title;
        private String director;
        private int yearCreated;
        private String genre;

        public Movie(String title, String director, int yearCreated, String genre)
        {
            this.title = title;
            this.director = director;
            this.yearCreated = yearCreated;
            this.genre = genre;
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

        public String toString()
        {
            return "Title: " + title + "\nDirector: " + director + "\nYear: " + yearCreated + "\nGenre: " + genre;
        }


    }
