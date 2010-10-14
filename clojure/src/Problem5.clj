; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
;
; What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

;first attempt
(defn factor [f n]
  "how many times does is f a factor of n. returns nil if not a factor"
  (let [t (/ n f)] (if (ratio? t) nil t))
  )

(defn smallest-num-divisible-by [low high]
  "find the smallest number divisible from l (inclusive) to h (inclusive)"
  (let [divisors (range low (+ high 1)) candidates (iterate #(+ high %) high)]
    (loop [cur (first candidates) remaing (rest candidates)]
      (if (every? #(factor % cur) divisors)
        cur
        (recur (first remaing) (rest remaing))))))

(println (time (smallest-num-divisible-by 1 20)))