package com.ismail.moviecatalogue.utils

import com.ismail.moviecatalogue.data.source.local.entity.MovieEntity
import com.ismail.moviecatalogue.data.source.local.entity.TvShowEntity
import com.ismail.moviecatalogue.data.source.remote.response.MovieResponse
import com.ismail.moviecatalogue.data.source.remote.response.TvShowResponse

object DataDummy {

    fun generateDummyMovies(): ArrayList<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
                MovieEntity(
                        "m1",
                        "Wonder Woman 1984",
                        "7,2/10",
                        "2h 31m",
                        "Dec 16, 2020",
                        "Fantasy, Action, Adventure",
                        "Patty Jenkins",
                        "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                        false
                )
        )
        movies.add(
                MovieEntity(
                        "m2",
                        "Heavenquest: A Pilgrim's Progress",
                        "5,4/10",
                        "1h 31m",
                        "Jul 13, 2020",
                        "Fantasy, Action, Adventure",
                        "Matt Bilen",
                        "Inspired by the 1678 novel The Pilgrim's Progress and an imagined prequel to Bunyan's original writings. A regal man named Vangel is thrust on a journey against his will when he is suddenly and mysteriously arrested. Injured and lost after escaping the dark king’s men, Vangel begins to have strange dreams and visions of a mysterious woman in white calling him from the unknown territory of the North. Armed with a book called “The Record of the Ancients” that he receives from a wise sage named Elder, Vangel embarks on an adventure that takes him through treacherous mountain range, unending deserts, the Lake of Doubts, and the Forest of No Return. Along the way, travel companions share about a fabled good king and his son in the North if he can make it there alive.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/cLDPLia17AwMqSaRHccyAlInkch.jpg", false)
        )

        movies.add(
                MovieEntity(
                        "m3",
                        "No Good Deed",
                        "6,4/10",
                        "1h 32m",
                        "Mar 13, 2020",
                        "Thriller",
                        "Caroline Labrèche",
                        "Karen never planned on being a hero. A recent widow, she has her hands full with work and parenting her son Max. Then Karen saves Jeremy's life during a drug store robbery and quickly discovers that the young man is intent on paying her back at any cost. At first, life starts improving for this good Samaritan, but as Jeremy's efforts become more extreme, Karen starts to wonder if no good deed truly goes unpunished.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/27BnREBR5rcMrUVUhV5bTXlcCym.jpg", false)
        )

        movies.add(
                MovieEntity(
                        "m4",
                        "Monsters of Man",
                        "7,2/10",
                        "2h 11m",
                        "Aug 12, 2020",
                        "Science Fiction",
                        "Mark Toia",
                        "A robotics company vying to win a lucrative military contract team up with a corrupt CIA agent to conduct an illegal live field test. They deploy four weaponized prototype robots into a suspected drug manufacturing camp in the Golden Triangle, assuming they'd be killing drug runners that no one would miss. Six doctors on a humanitarian mission witness the brutal slaughter and become prime targets.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1f3qspv64L5FXrRy0MF8X92ieuw.jpg", false)
        )

        movies.add(
                MovieEntity(
                        "m5",
                        "The Croods: A New Age",
                        "7,7/10",
                        "1h 35m",
                        "Dec 23, 2020",
                        "Adventure, Fantasy, Family, Animation",
                        "Joel Crawford",
                        "Searching for a safer habitat, the prehistoric Crood family discovers an idyllic, walled-in paradise that meets all of its needs. Unfortunately, they must also learn to live with the Bettermans -- a family that's a couple of steps above the Croods on the evolutionary ladder. As tensions between the new neighbors start to rise, a new threat soon propels both clans on an epic adventure that forces them to embrace their differences, draw strength from one another, and survive together.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tK1zy5BsCt1J4OzoDicXmr0UTFH.jpg", false)
        )

        movies.add(
                MovieEntity(
                        "m6",
                        "Cosmoball",
                        "5,3/10",
                        "1h 55m",
                        "Aug 27, 2020",
                        "Science Fiction, Adventure",
                        "Dzhanik Fayziev",
                        "Cosmoball is a mesmerizing intergalactic game of future played between humans and aliens at the giant extraterrestrial ship hovering in the sky over Earth. A young man with enormous power of an unknown nature joins the team of hot-headed superheroes in exchange for a cure for his mother’s deadly illness. The Four from Earth will fight not only to defend the honor of their home planet in the spectacular game, but to face the unprecedented threat to the Galaxy and embrace their own destiny.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eDJYDXRoWoUzxjd52gtz5ODTSU1.jpg", false)
        )

        movies.add(
                MovieEntity(
                        "m7",
                        "Battleship",
                        "5,7/10",
                        "2h 11m",
                        "Nov 04, 2012",
                        "Thriller, Action, Adventure, Science Fiction",
                        "Peter Berg",
                        "When mankind beams a radio signal into space, a reply comes from ‘Planet G’, in the form of several alien crafts that splash down in the waters off Hawaii. Lieutenant Alex Hopper is a weapons officer assigned to the USS John Paul Jones, part of an international naval coalition which becomes the world's last hope for survival as they engage the hostile alien force of unimaginable strength. While taking on the invaders, Hopper must also try to live up to the potential that his brother, and his fiancée's father—an Admiral—expect of him.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mXb3hot6ZW4hMfpZSK7UtD70WgM.jpg", false)
        )
        movies.add(
                MovieEntity(
                        "m8",
                        "Soul",
                        "8,4/10",
                        "1h 42m",
                        "Dec 25, 2020",
                        "Animation, Comedy, Drama, Music, Fantasy",
                        "Pete Docter",
                        "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg", false)
        )

        movies.add(
                MovieEntity(
                        "m9",
                        "Naruto Shippuden the Movie ",
                        "7,2/10",
                        "1h 34m",
                        "Aug 04, 2007",
                        "Family, Action, Animation, Adventure, Fantasy",
                        "Hajime Kamegaki",
                        "Demons that once almost destroyed the world, are revived by someone. To prevent the world from being destroyed, the demon has to be sealed and the only one who can do it is the shrine maiden Shion from the country of demons, who has two powers; one is sealing demons and the other is predicting the deaths of humans. This time Naruto's mission is to guard Shion, but she predicts Naruto's death. The only way to escape it, is to get away from Shion, which would leave her unguarded, then the demon, whose only goal is to kill Shion will do so, thus meaning the end of the world. Naruto decides to challenge this prediction of death.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vDkct38sSFSWJIATlfJw0l3QOIR.jpg", false)
        )

        movies.add(
                MovieEntity(
                        "m10",
                        "Mulan",
                        "7,1/10",
                        "1h 55m",
                        "Sep 04, 2020",
                        "Adventure, Fantasy",
                        "Niki Caro",
                        "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg", false)
        )

        return movies
    }

    fun generateDummyTvShow(): ArrayList<TvShowEntity> {

        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
                TvShowEntity(
                        "tv1",
                        "Cobra Kai",
                        "8,1/10",
                        "30min",
                        "May 02, 2018",
                        "Action & Adventure, Drama",
                        "Hayden Schlossberg",
                        "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/obLBdhLxheKg8Li1qO11r2SwmYO.jpg", false)
        )
        tvShows.add(
                TvShowEntity(
                        "tv2",
                        "Jujutsu Kaisen",
                        "8,7/10",
                        "24m",
                        "Oct 23, 2020",
                        "Animation, Action & Adventure, Sci-Fi & Fantasy",
                        "Yuuji Itadori",
                        "Yuuji Itadori is a boy with tremendous physical strength, though he lives a completely ordinary high school life. One day, to save a friend who has been attacked by Curses, he eats a finger of Ryoumen Sukuna, taking the Curse into his own soul. From then on, he shares one body with Sukuna. Guided by the most powerful of sorcerers, Satoru Gojou, Itadori is admitted to the Tokyo Prefectural Jujutsu High School, an organization that fights the Curses... and thus begins the heroic tale of a boy who became a Curse to exorcise a Curse, a life from which he could never turn back.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/g1rK2nRXSidcMwNliWDIroWWGTn.jpg", false)
        )

        tvShows.add(
                TvShowEntity(
                        "tv3",
                        "Game of Thrones",
                        "8,4/10",
                        "60m",
                        "May 11, 2011",
                        "Sci-Fi & Fantasy, Drama, Action & Adventure, Mystery",
                        "David Benioff",
                        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg", false)
        )

        tvShows.add(
                TvShowEntity(
                        "tv4",
                        "The Simpsons",
                        "7,8/10",
                        "22m",
                        "1989",
                        "Animation, Comedy, Family, Drama",
                        "Matt Groening",
                        "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg", false)
        )

        tvShows.add(
                TvShowEntity(
                        "tv5",
                        "Sweet Home",
                        "8,6/10",
                        "52m",
                        "Dec 18, 2020",
                        "Drama, Sci-Fi & Fantasy",
                        "Pyeon Sang-wook",
                        "Cha Hyun-Soo is a high school student. He is also a recluse and rarely leaves his room. He refuses to talk to his father, mother and younger sister. One day, his whole family, except for him, dies in a car accident. Cha Hyun-Soo is left all alone. He moves into a small apartment. At this time, a mysterious phenomenon of humans turning into monster occur all around the world. The residents of Cha Hyun-Soo's apartment building, including Pyeon Sang-Wook, fight against these monsters and try to survive.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6eMg81CPLalULg8spPt2LxfQtFj.jpg", false)
        )


        tvShows.add(
                TvShowEntity(
                        "tv6",
                        "The Lord of the Skies",
                        "7,7/10",
                        "45m",
                        "2013",
                        "Crime, Drama, Soap",
                        "Mariano Calasso",
                        "Set in the 1990s, these are the life and times of Amado Carrillo Fuentes, a man who became the head of the Juárez cartel. Nicknamed “El Señor de los Cielos” (Lord of the Skies) because of the large fleet of airplanes he used to transport drugs, he was also known for washing more than $200 million through Colombia to finance his huge fleet. He is described as the most powerful drug trafficker of his time.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/Ag7VUdnrRz5Qpq3Yn3E5OCvFnu0.jpg", false)
        )




        tvShows.add(
                TvShowEntity(
                        "tv7",
                        "The Flash",
                        "7,6/10",
                        "44m",
                        "2014",
                        "Drama, Sci-Fi & Fantasy",
                        "Greg Berlanti",
                        "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only meta-human who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg", false)
        )


        tvShows.add(
                TvShowEntity(
                        "tv8",
                        "Valor",
                        "6,5/10",
                        "43m",
                        "2017",
                        "Drama",
                        "Kyle Jarrow",
                        "The boundaries between military discipline and human desire are tested on a U.S. Army base that houses an elite unit of helicopter pilots trained to perform clandestine international and domestic missions. The drama unfolds in the present as well as in flashbacks to a failed mission involving one of the first female pilots in the unit, ultimately uncovering layers of personal and government/military secrets and leading to a season-long plan to rescue a group of MIA soldiers.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pJKRWAp0ZO8zM5VhGlISusLrbXs.jpg", false)
        )

        tvShows.add(
                TvShowEntity(
                        "tv9",
                        "Mind Games",
                        "6,4/10",
                        "60m",
                        "2017",
                        "Drama",
                        "Christian Slater",
                        "Clark and Ross Edwards are brothers and partners in a unique agency committed to solving clients’ problems using the hard science of psychological manipulation. Clark is a former professor and a world-renowned expert in the field of human behavior. He has a checkered history due to bipolar disorder, which sometimes results in quirky, manic episodes. His older brother Ross is a slick con man who spent time in prison. Each in their own way knows what makes people tick. Drawing from the most cutting edge research in psychology, they can a tailor a plan to influence any situation. It’s a little bit science, a little bit con artistry plus a smattering of Jedi mind tricks. The brothers, along with their team of master manipulators are offering clients an alternative to fate.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qAnfbp1rvKdksaxHK7N865R6E4P.jpg", false)
        )

        tvShows.add(
                TvShowEntity(
                        "tv10",
                        "Money Heist",
                        "8,3/10",
                        "1h 10m",
                        "2017",
                        "Crime, Drama",
                        "Alex Pina",
                        "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/MoEKaPFHABtA1xKoOteirGaHl1.jpg", false)
        )
        return tvShows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(
                MovieResponse(
                        "m1",
                        "Wonder Woman 1984",
                        "7,2/10",
                        "2h 31m",
                        "Dec 16, 2020",
                        "Fantasy, Action, Adventure",
                        "Patty Jenkins",
                        "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg")
        )
        movies.add(
                MovieResponse(
                        "m2",
                        "Heavenquest: A Pilgrim's Progress",
                        "5,4/10",
                        "1h 31m",
                        "Jul 13, 2020",
                        "Fantasy, Action, Adventure",
                        "Matt Bilen",
                        "Inspired by the 1678 novel The Pilgrim's Progress and an imagined prequel to Bunyan's original writings. A regal man named Vangel is thrust on a journey against his will when he is suddenly and mysteriously arrested. Injured and lost after escaping the dark king’s men, Vangel begins to have strange dreams and visions of a mysterious woman in white calling him from the unknown territory of the North. Armed with a book called “The Record of the Ancients” that he receives from a wise sage named Elder, Vangel embarks on an adventure that takes him through treacherous mountain range, unending deserts, the Lake of Doubts, and the Forest of No Return. Along the way, travel companions share about a fabled good king and his son in the North if he can make it there alive.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/cLDPLia17AwMqSaRHccyAlInkch.jpg")
        )

        movies.add(
                MovieResponse(
                        "m3",
                        "No Good Deed",
                        "6,4/10",
                        "1h 32m",
                        "Mar 13, 2020",
                        "Thriller",
                        "Caroline Labrèche",
                        "Karen never planned on being a hero. A recent widow, she has her hands full with work and parenting her son Max. Then Karen saves Jeremy's life during a drug store robbery and quickly discovers that the young man is intent on paying her back at any cost. At first, life starts improving for this good Samaritan, but as Jeremy's efforts become more extreme, Karen starts to wonder if no good deed truly goes unpunished.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/27BnREBR5rcMrUVUhV5bTXlcCym.jpg")
        )

        movies.add(
                MovieResponse(
                        "m4",
                        "Monsters of Man",
                        "7,2/10",
                        "2h 11m",
                        "Aug 12, 2020",
                        "Science Fiction",
                        "Mark Toia",
                        "A robotics company vying to win a lucrative military contract team up with a corrupt CIA agent to conduct an illegal live field test. They deploy four weaponized prototype robots into a suspected drug manufacturing camp in the Golden Triangle, assuming they'd be killing drug runners that no one would miss. Six doctors on a humanitarian mission witness the brutal slaughter and become prime targets.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1f3qspv64L5FXrRy0MF8X92ieuw.jpg")
        )

        movies.add(
                MovieResponse(
                        "m5",
                        "The Croods: A New Age",
                        "7,7/10",
                        "1h 35m",
                        "Dec 23, 2020",
                        "Adventure, Fantasy, Family, Animation",
                        "Joel Crawford",
                        "Searching for a safer habitat, the prehistoric Crood family discovers an idyllic, walled-in paradise that meets all of its needs. Unfortunately, they must also learn to live with the Bettermans -- a family that's a couple of steps above the Croods on the evolutionary ladder. As tensions between the new neighbors start to rise, a new threat soon propels both clans on an epic adventure that forces them to embrace their differences, draw strength from one another, and survive together.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tK1zy5BsCt1J4OzoDicXmr0UTFH.jpg")
        )

        movies.add(
                MovieResponse(
                        "m6",
                        "Cosmoball",
                        "5,3/10",
                        "1h 55m",
                        "Aug 27, 2020",
                        "Science Fiction, Adventure",
                        "Dzhanik Fayziev",
                        "Cosmoball is a mesmerizing intergalactic game of future played between humans and aliens at the giant extraterrestrial ship hovering in the sky over Earth. A young man with enormous power of an unknown nature joins the team of hot-headed superheroes in exchange for a cure for his mother’s deadly illness. The Four from Earth will fight not only to defend the honor of their home planet in the spectacular game, but to face the unprecedented threat to the Galaxy and embrace their own destiny.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/eDJYDXRoWoUzxjd52gtz5ODTSU1.jpg")
        )

        movies.add(
                MovieResponse(
                        "m7",
                        "Battleship",
                        "5,7/10",
                        "2h 11m",
                        "Nov 04, 2012",
                        "Thriller, Action, Adventure, Science Fiction",
                        "Peter Berg",
                        "When mankind beams a radio signal into space, a reply comes from ‘Planet G’, in the form of several alien crafts that splash down in the waters off Hawaii. Lieutenant Alex Hopper is a weapons officer assigned to the USS John Paul Jones, part of an international naval coalition which becomes the world's last hope for survival as they engage the hostile alien force of unimaginable strength. While taking on the invaders, Hopper must also try to live up to the potential that his brother, and his fiancée's father—an Admiral—expect of him.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/mXb3hot6ZW4hMfpZSK7UtD70WgM.jpg")
        )
        movies.add(
                MovieResponse(
                        "m8",
                        "Soul",
                        "8,4/10",
                        "1h 42m",
                        "Dec 25, 2020",
                        "Animation, Comedy, Drama, Music, Fantasy",
                        "Pete Docter",
                        "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg")
        )

        movies.add(
                MovieResponse(
                        "m9",
                        "Naruto Shippuden the Movie ",
                        "7,2/10",
                        "1h 34m",
                        "Aug 04, 2007",
                        "Family, Action, Animation, Adventure, Fantasy",
                        "Hajime Kamegaki",
                        "Demons that once almost destroyed the world, are revived by someone. To prevent the world from being destroyed, the demon has to be sealed and the only one who can do it is the shrine maiden Shion from the country of demons, who has two powers; one is sealing demons and the other is predicting the deaths of humans. This time Naruto's mission is to guard Shion, but she predicts Naruto's death. The only way to escape it, is to get away from Shion, which would leave her unguarded, then the demon, whose only goal is to kill Shion will do so, thus meaning the end of the world. Naruto decides to challenge this prediction of death.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/vDkct38sSFSWJIATlfJw0l3QOIR.jpg")
        )

        movies.add(
                MovieResponse(
                        "m10",
                        "Mulan",
                        "7,1/10",
                        "1h 55m",
                        "Sep 04, 2020",
                        "Adventure, Fantasy",
                        "Niki Caro",
                        "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg")
        )

        return movies
    }

    fun generateRemoteDummyTvShow(): ArrayList<TvShowResponse> {

        val tvShows = ArrayList<TvShowResponse>()

        tvShows.add(
                TvShowResponse(
                        "tv1",
                        "Cobra Kai",
                        "8,1/10",
                        "30min",
                        "May 02, 2018",
                        "Action & Adventure, Drama",
                        "Hayden Schlossberg",
                        "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/obLBdhLxheKg8Li1qO11r2SwmYO.jpg")
        )
        tvShows.add(
                TvShowResponse(
                        "tv2",
                        "Jujutsu Kaisen",
                        "8,7/10",
                        "24m",
                        "Oct 23, 2020",
                        "Animation, Action & Adventure, Sci-Fi & Fantasy",
                        "Yuuji Itadori",
                        "Yuuji Itadori is a boy with tremendous physical strength, though he lives a completely ordinary high school life. One day, to save a friend who has been attacked by Curses, he eats a finger of Ryoumen Sukuna, taking the Curse into his own soul. From then on, he shares one body with Sukuna. Guided by the most powerful of sorcerers, Satoru Gojou, Itadori is admitted to the Tokyo Prefectural Jujutsu High School, an organization that fights the Curses... and thus begins the heroic tale of a boy who became a Curse to exorcise a Curse, a life from which he could never turn back.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/g1rK2nRXSidcMwNliWDIroWWGTn.jpg")
        )

        tvShows.add(
                TvShowResponse(
                        "tv3",
                        "Game of Thrones",
                        "8,4/10",
                        "60m",
                        "May 11, 2011",
                        "Sci-Fi & Fantasy, Drama, Action & Adventure, Mystery",
                        "David Benioff",
                        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg")
        )

        tvShows.add(
                TvShowResponse(
                        "tv4",
                        "The Simpsons",
                        "7,8/10",
                        "22m",
                        "1989",
                        "Animation, Comedy, Family, Drama",
                        "Matt Groening",
                        "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg")
        )

        tvShows.add(
                TvShowResponse(
                        "tv5",
                        "Sweet Home",
                        "8,6/10",
                        "52m",
                        "Dec 18, 2020",
                        "Drama, Sci-Fi & Fantasy",
                        "Pyeon Sang-wook",
                        "Cha Hyun-Soo is a high school student. He is also a recluse and rarely leaves his room. He refuses to talk to his father, mother and younger sister. One day, his whole family, except for him, dies in a car accident. Cha Hyun-Soo is left all alone. He moves into a small apartment. At this time, a mysterious phenomenon of humans turning into monster occur all around the world. The residents of Cha Hyun-Soo's apartment building, including Pyeon Sang-Wook, fight against these monsters and try to survive.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6eMg81CPLalULg8spPt2LxfQtFj.jpg")
        )


        tvShows.add(
                TvShowResponse(
                        "tv6",
                        "The Lord of the Skies",
                        "7,7/10",
                        "45m",
                        "2013",
                        "Crime, Drama, Soap",
                        "Mariano Calasso",
                        "Set in the 1990s, these are the life and times of Amado Carrillo Fuentes, a man who became the head of the Juárez cartel. Nicknamed “El Señor de los Cielos” (Lord of the Skies) because of the large fleet of airplanes he used to transport drugs, he was also known for washing more than $200 million through Colombia to finance his huge fleet. He is described as the most powerful drug trafficker of his time.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/Ag7VUdnrRz5Qpq3Yn3E5OCvFnu0.jpg")
        )




        tvShows.add(
                TvShowResponse(
                        "tv7",
                        "The Flash",
                        "7,6/10",
                        "44m",
                        "2014",
                        "Drama, Sci-Fi & Fantasy",
                        "Greg Berlanti",
                        "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only meta-human who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg")
        )


        tvShows.add(
                TvShowResponse(
                        "tv8",
                        "Valor",
                        "6,5/10",
                        "43m",
                        "2017",
                        "Drama",
                        "Kyle Jarrow",
                        "The boundaries between military discipline and human desire are tested on a U.S. Army base that houses an elite unit of helicopter pilots trained to perform clandestine international and domestic missions. The drama unfolds in the present as well as in flashbacks to a failed mission involving one of the first female pilots in the unit, ultimately uncovering layers of personal and government/military secrets and leading to a season-long plan to rescue a group of MIA soldiers.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pJKRWAp0ZO8zM5VhGlISusLrbXs.jpg")
        )

        tvShows.add(
                TvShowResponse(
                        "tv9",
                        "Mind Games",
                        "6,4/10",
                        "60m",
                        "2017",
                        "Drama",
                        "Christian Slater",
                        "Clark and Ross Edwards are brothers and partners in a unique agency committed to solving clients’ problems using the hard science of psychological manipulation. Clark is a former professor and a world-renowned expert in the field of human behavior. He has a checkered history due to bipolar disorder, which sometimes results in quirky, manic episodes. His older brother Ross is a slick con man who spent time in prison. Each in their own way knows what makes people tick. Drawing from the most cutting edge research in psychology, they can a tailor a plan to influence any situation. It’s a little bit science, a little bit con artistry plus a smattering of Jedi mind tricks. The brothers, along with their team of master manipulators are offering clients an alternative to fate.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qAnfbp1rvKdksaxHK7N865R6E4P.jpg")
        )

        tvShows.add(
                TvShowResponse(
                        "tv10",
                        "Money Heist",
                        "8,3/10",
                        "1h 10m",
                        "2017",
                        "Crime, Drama",
                        "Alex Pina",
                        "To carry out the biggest heist in history, a mysterious man called The Professor recruits a band of eight robbers who have a single characteristic: none of them has anything to lose. Five months of seclusion - memorizing every step, every detail, every probability - culminate in eleven days locked up in the National Coinage and Stamp Factory of Spain, surrounded by police forces and with dozens of hostages in their power, to find out whether their suicide wager will lead to everything or nothing.",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/MoEKaPFHABtA1xKoOteirGaHl1.jpg")
        )
        return tvShows
    }

}