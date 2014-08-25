(ns haunted.core
  (require [haunted.util :as util]))

(def prompt "::> ")

(def splash-msg "Welcome to Haunted Hideout.
                 You were driving down a long, dark road during a gully-washing thunderstorm, when a strange
                 mist drifted across the road. You remember slowing down due to the reduced visibility, and
                 then there was some kind of large, nearly-human shape lumbering across the road, and you
                 swerved...

                 It's still a bit vague. Apparently there was an accident... you have half a memory of slogging
                 through rain and and branches towards a distant light, like a candle in a window. And now you're
                 here.

                 Wherever here is.")

(defn get-input [& prompt]
  (when-let [p (first prompt)]
    (print p)
    (flush))
  (read-line))

(defn main-loop [input]
  (when (not= input "quit")
    (recur (get-input prompt))))

(defn -main [& args]
  (println (util/trim-long splash-msg))
  (println)
  (main-loop (get-input prompt)))
