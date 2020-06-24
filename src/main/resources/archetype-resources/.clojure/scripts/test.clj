;; Require cljs.main and clojure.pprint
(require '(cljs [main :as m])
         '(clojure [pprint :as prnt]))

;; Compile cljs files
(apply m/-main *command-line-args*)
