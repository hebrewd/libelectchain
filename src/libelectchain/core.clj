(ns libelectchain.core
  (:require [buddy.core.keys :as keys]
            [buddy.core.hash :as hash]
            [buddy.core.codecs :refer :all]
            [buddy.core.dsa :as dsa]))

(def blockchain (atom {}))
(def pending (atom (vector)))
(def private-key (keys/private-key "/tmp/privatekey.pem"))
(def public-key (keys/public-key "/tmp/publickey.pem"))

(verify (first @pending))

(item->sha256 1 2 4)

(defn item->sha256 [to coin sig]
  (-> (str to coin sig)
  (hash/sha256)
  (bytes->hex)))

(defn verify [{:keys [sha to coin sig]} item]
  (let [datastring (str sha to coin)]
      (cond
        (dsa/verify datastring sig {:key public-key :alg :rsassa-pss+sha256}) (swap! blockchain assoc sha item)
        (dsa/verify datastring (:sig (get @blockchain coin)) {:key public-key :agl :rsassa-pss+sha256}) (swap! blockchain assoc sha item))

(defn append [sha to coin sig]
  (let [item {:sha sha :to to :coin coin :sig sig}]
    (if (= (item->sha256 to coin sig) sha) (swap! pending conj item))))

(defn foo "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
