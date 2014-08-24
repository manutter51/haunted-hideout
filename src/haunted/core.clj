(ns haunted.core)

(def prompt "Type \"quit\" to exit: ")

(defn get-input [& prompt]
  (when-let [p (first prompt)]
    (print p)
    (flush))
  (read-line))

(defn main-loop [input]
  (when (not= input "quit")
    (recur (get-input prompt))))

(defn -main [& args]
  (main-loop (get-input prompt)))
