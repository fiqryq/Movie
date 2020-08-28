package com.fiqryq.themoviedb.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    /**
     * page : 1
     * total_results : 10000
     * total_pages : 500
     * results : [{"popularity":346.971,"vote_count":303,"video":false,"poster_path":"/k68nPLbIST6NP96JmTxmZijEvCA.jpg","id":577922,"adult":false,"backdrop_path":"/wzJRB4MKi3yK138bJyuL9nx47y6.jpg","original_language":"en","original_title":"Tenet","genre_ids":[28,53],"title":"Tenet","vote_average":7.6,"overview":"Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.","release_date":"2020-08-22"},{"popularity":438.63,"vote_count":841,"video":false,"poster_path":"/TnOeov4w0sTtV2gqICqIxVi74V.jpg","id":605116,"adult":false,"backdrop_path":"/qVygtf2vU15L2yKS4Ke44U4oMdD.jpg","original_language":"en","original_title":"Project Power","genre_ids":[28,80,878],"title":"Project Power","vote_average":6.7,"overview":"An ex-soldier, a teen and a cop collide in New Orleans as they hunt for the source behind a dangerous new pill that grants users temporary superpowers.","release_date":"2020-08-14"},{"popularity":268.52,"vote_count":106,"video":false,"poster_path":"/A3z0KMLIEGL22mVrgaV7KDxKRmT.jpg","id":539885,"adult":false,"backdrop_path":"/ekkuqt9Q2ad1F7xq2ZONP0oq36P.jpg","original_language":"en","original_title":"Ava","genre_ids":[28,80,18,53],"title":"Ava","vote_average":6.5,"overview":"A black ops assassin is forced to fight for her own survival after a job goes dangerously wrong.","release_date":"2020-08-06"},{"popularity":311.401,"vote_count":78,"video":false,"poster_path":"/uOw5JD8IlD546feZ6oxbIjvN66P.jpg","id":718444,"adult":false,"backdrop_path":"/jvKIBaMssk3D7ZH4VF4rLz6A3OK.jpg","original_language":"en","original_title":"Rogue","genre_ids":[28],"title":"Rogue","vote_average":6,"overview":"Battle-hardened O\u2019Hara leads a lively mercenary team of soldiers on a daring mission: rescue hostages from their captors in remote Africa. But as the mission goes awry and the team is stranded, O\u2019Hara\u2019s squad must face a bloody, brutal encounter with a gang of rebels.","release_date":"2020-08-20"},{"popularity":213.725,"vote_count":199,"video":false,"poster_path":"/q1MNlZYqhoD4U7sd7pjxD6SUf4z.jpg","id":621013,"adult":false,"backdrop_path":"/1eq896TCOEeN9Q8iTJL0n9u31Qf.jpg","original_language":"en","original_title":"Chemical Hearts","genre_ids":[18,10749],"title":"Chemical Hearts","vote_average":8.2,"overview":"A high school transfer student finds a new passion when she begins to work on the school's newspaper.","release_date":"2020-08-21"},{"popularity":218,"vote_count":71,"video":false,"poster_path":"/6Bbq8qQWpoApLZYWFFAuZ1r2gFw.jpg","id":618354,"adult":false,"backdrop_path":"/bazlsLkNuhy3IuhviepqvlMm2hV.jpg","original_language":"en","original_title":"Superman: Man of Tomorrow","genre_ids":[28,16,878],"title":"Superman: Man of Tomorrow","vote_average":7.6,"overview":"It\u2019s the dawn of a new age of heroes, and Metropolis has just met its first. But as Daily Planet intern Clark Kent \u2013 working alongside reporter Lois Lane \u2013 secretly wields his alien powers of flight, super-strength and x-ray vision in the battle for good, there\u2019s even greater trouble on the horizon.","release_date":"2020-08-23"},{"popularity":176.852,"vote_count":76,"video":false,"poster_path":"/9iEc34Qje2V3FZnrSXKfZsbiHjW.jpg","id":626393,"adult":false,"backdrop_path":"/mQngZ4DtXqdkX9fOQRsm9iym5OW.jpg","original_language":"en","original_title":"The Sleepover","genre_ids":[28,10751],"title":"The Sleepover","vote_average":6.9,"overview":"Two siblings who discover their seemingly normal mom is a former thief in witness protection. Mom is forced to pull one last job, and the kids team up to rescue her over the course of an action-packed night.","release_date":"2020-08-21"},{"popularity":157.902,"vote_count":19444,"video":false,"poster_path":"/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg","id":299536,"adult":false,"backdrop_path":"/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg","original_language":"en","original_title":"Avengers: Infinity War","genre_ids":[28,12,878],"title":"Avengers: Infinity War","vote_average":8.3,"overview":"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.","release_date":"2018-04-25"},{"popularity":176.457,"vote_count":14477,"video":false,"poster_path":"/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg","id":475557,"adult":false,"backdrop_path":"/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg","original_language":"en","original_title":"Joker","genre_ids":[80,18,53],"title":"Joker","vote_average":8.2,"overview":"During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.","release_date":"2019-10-02"},{"popularity":103.335,"vote_count":65,"video":false,"poster_path":"/e7ZsW5EbLbQwoGx0548KCmCAXA9.jpg","id":508570,"adult":false,"backdrop_path":"/fFdOJxmG2U7IYYlkFKtDk1nGPhF.jpg","original_language":"en","original_title":"The One and Only Ivan","genre_ids":[35,18,10751],"title":"The One and Only Ivan","vote_average":7.2,"overview":"Ivan is a 400-pound silverback gorilla who shares a communal habitat in a suburban shopping mall with Stella the elephant, Bob the dog, and various other animals. He has few memories of the jungle where he was captured, but when a baby elephant named Ruby arrives, it touches something deep within him. Ruby is recently separated from her family in the wild, which causes him to question his life, where he comes from and where he ultimately wants to be.","release_date":"2020-08-21"},{"popularity":117.016,"vote_count":17,"video":false,"poster_path":"/xZNw9xxtwbEf25NYoz52KdbXHPM.jpg","id":340102,"adult":false,"backdrop_path":"/p9pFLEi0QEaukxJqMIfEzPtprrv.jpg","original_language":"en","original_title":"The New Mutants","genre_ids":[28,12,27,878],"title":"The New Mutants","vote_average":4.9,"overview":"Five young mutants, just discovering their abilities while held in a secret facility against their will, fight to escape their past sins and save themselves.","release_date":"2020-08-26"},{"popularity":110.085,"vote_count":5081,"video":false,"poster_path":"/azL2ThbJMIkts3ZMt3j1YgBUeDB.jpg","id":98566,"adult":false,"backdrop_path":"/3eGlcdyxqEN57TtU8ypx52V4JMs.jpg","original_language":"en","original_title":"Teenage Mutant Ninja Turtles","genre_ids":[28,12,35,878],"title":"Teenage Mutant Ninja Turtles","vote_average":5.9,"overview":"The city needs heroes. Darkness has settled over New York City as Shredder and his evil Foot Clan have an iron grip on everything from the police to the politicians. The future is grim until four unlikely outcast brothers rise from the sewers and discover their destiny as Teenage Mutant Ninja Turtles. The Turtles must work with fearless reporter April and her wise-cracking cameraman Vern Fenwick to save the city and unravel Shredder's diabolical plan.","release_date":"2014-08-07"},{"popularity":100.897,"vote_count":26953,"video":false,"poster_path":"/9gk7adHYeDvHkCSEqAvQNLV5Uge.jpg","id":27205,"adult":false,"backdrop_path":"/s3TBrRGB1iav7gFOCNx3H31MoES.jpg","original_language":"en","original_title":"Inception","genre_ids":[28,12,878],"title":"Inception","vote_average":8.3,"overview":"Cobb, a skilled thief who commits corporate espionage by infiltrating the subconscious of his targets is offered a chance to regain his old life as payment for a task considered to be impossible: \"inception\", the implantation of another person's idea into a target's subconscious.","release_date":"2010-07-15"},{"popularity":90.475,"vote_count":16876,"video":false,"poster_path":"/8tZYtuWezp8JbcsvHYO0O46tFbo.jpg","id":76341,"adult":false,"backdrop_path":"/nlCHUWjY9XWbuEUQauCBgnY8ymF.jpg","original_language":"en","original_title":"Mad Max: Fury Road","genre_ids":[28,12,878],"title":"Mad Max: Fury Road","vote_average":7.5,"overview":"An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order.","release_date":"2015-05-13"},{"popularity":129.301,"vote_count":8175,"video":false,"poster_path":"/4q2NNj4S5dG2RLF9CpXsej7yXl.jpg","id":429617,"adult":false,"backdrop_path":"/5myQbDzw3l8K9yofUXRJ4UTVgam.jpg","original_language":"en","original_title":"Spider-Man: Far from Home","genre_ids":[28,12,878],"title":"Spider-Man: Far from Home","vote_average":7.5,"overview":"Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.","release_date":"2019-06-28"},{"popularity":137.5,"vote_count":5550,"video":false,"poster_path":"/h4VB6m0RwcicVEZvzftYZyKXs6K.jpg","id":495764,"adult":false,"backdrop_path":"/9xNOiv6DZZjH7ABoUUDP0ZynouU.jpg","original_language":"en","original_title":"Birds of Prey (and the Fantabulous Emancipation of One Harley Quinn)","genre_ids":[28,35,80],"title":"Birds of Prey (and the Fantabulous Emancipation of One Harley Quinn)","vote_average":7.2,"overview":"Harley Quinn joins forces with a singer, an assassin and a police detective to help a young girl who had a hit placed on her after she stole a rare diamond from a crime lord.","release_date":"2020-02-05"},{"popularity":98.1,"vote_count":6645,"video":false,"poster_path":"/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg","id":420818,"adult":false,"backdrop_path":"/nRXO2SnOA75OsWhNhXstHB8ZmI3.jpg","original_language":"en","original_title":"The Lion King","genre_ids":[12,10402,10751],"title":"The Lion King","vote_average":7.2,"overview":"Simba idolizes his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother\u2014and former heir to the throne\u2014has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.","release_date":"2019-07-12"},{"popularity":135.332,"vote_count":37,"video":false,"poster_path":"/i4kPwXPlM1iy8Jf3S1uuLuwqQAV.jpg","id":721452,"adult":false,"backdrop_path":"/riDrpqQtZpXGeiJdlmfcwwPH7nN.jpg","original_language":"en","original_title":"One Night in Bangkok","genre_ids":[28,53],"title":"One Night in Bangkok","vote_average":7.8,"overview":"A hit man named Kai flies into Bangkok, gets a gun, and orders a cab. He offers a professional female driver big money to be his all-night driver. But when she realizes Kai is committing brutal murders at each stop, it's too late to walk away. Meanwhile, an offbeat police detective races to decode the string of slayings before more blood is spilled.","release_date":"2020-08-25"},{"popularity":130.032,"vote_count":8915,"video":false,"poster_path":"/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg","id":496243,"adult":false,"backdrop_path":"/ApiBzeaa95TNYliSbQ8pJv4Fje7.jpg","original_language":"ko","original_title":"기생충","genre_ids":[35,18,53],"title":"Parasite","vote_average":8.5,"overview":"All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.","release_date":"2019-05-30"},{"popularity":125.93,"vote_count":1004,"video":false,"poster_path":"/kjMbDciooTbJPofVXgAoFjfX8Of.jpg","id":516486,"adult":false,"backdrop_path":"/xXBnM6uSTk6qqCf0SRZKXcga9Ba.jpg","original_language":"en","original_title":"Greyhound","genre_ids":[28,18,10752],"title":"Greyhound","vote_average":7.5,"overview":"A first-time captain leads a convoy of allied ships carrying thousands of soldiers across the treacherous waters of the \u201cBlack Pit\u201d to the front lines of WW2. With no air cover protection for 5 days, the captain and his convoy must battle the surrounding enemy Nazi U-boats in order to give the allies a chance to win the war.","release_date":"2020-06-19"}]
     */

    private int page;
    private int total_results;
    private int total_pages;
    private List<ResultsBean> results;

    public Movie(Context applicationContext, ArrayList<Movie> arrayList) {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * popularity : 346.971
         * vote_count : 303
         * video : false
         * poster_path : /k68nPLbIST6NP96JmTxmZijEvCA.jpg
         * id : 577922
         * adult : false
         * backdrop_path : /wzJRB4MKi3yK138bJyuL9nx47y6.jpg
         * original_language : en
         * original_title : Tenet
         * genre_ids : [28,53]
         * title : Tenet
         * vote_average : 7.6
         * overview : Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.
         * release_date : 2020-08-22
         */

        private double popularity;
        private int vote_count;
        private boolean video;
        private String poster_path;
        private int id;
        private boolean adult;
        private String backdrop_path;
        private String original_language;
        private String original_title;
        private String title;
        private double vote_average;
        private String overview;
        private String release_date;
        private List<Integer> genre_ids;

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }
    }
}
