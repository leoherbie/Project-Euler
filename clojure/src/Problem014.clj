; The following iterative sequence is defined for the set of positive integers:
;
; n->n/2 (n is even)
; n->3n + 1 (n is odd)
;
; Using the rule above and starting with 13, we generate the following sequence:
;
; 13->40->20->10->5->16->8->4->2->1
;
; It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
; Although it has not been proved yet (Collatz Problem),
; it is thought that all starting numbers finish at 1.
;
; Which starting number, under one million, produces the longest chain?
;
; NOTE: Once the chain starts the terms are allowed to go above one million.
;******************************************************************************************************

; first attempt
(defn even-fn [n] (/ n 2))
(defn odd-fn [n] (+ (* 3 n) 1))

(defn apply-fn [n] (if (even? n) (even-fn n) (odd-fn n)))

;FIXME: need to try to figure out if I can cache sequence somehow....
(defn itr-sequence [start] (iterate apply-fn start))

(defn chain-count [start] (+ (count (take-while #(> % 1) (itr-sequence start))) 1))

(defn longest-chain [end]
  (loop [start 2 longest-start 0 longest-num-terms 0]
    (let [term-count (chain-count start) new-longest (> term-count longest-num-terms)]
      (if (> start end)
        [longest-start longest-num-terms]
        (recur (inc start)
          (if (identity new-longest) start longest-start)
          (if (identity new-longest) term-count longest-num-terms))))))

(println (time (longest-chain 999999)))