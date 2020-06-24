;; Import Java classes
(import (java.nio.file SimpleFileVisitor FileVisitResult Files)
        (java.io File))

;; Require cljs.main
(require '(cljs [main :as m]))

;; Source directory
(def source-path
  "Path representing source directory"
  (-> (System/getProperties)
      (get "maven.source.dir")
      (File.)
      (.toPath)))

;; Atom to collect paths to cljs source files.
(def cljs-paths (atom []))

;; FileVisitor compile proxy.
(def visitor
  "Java SimpleFileVisitor - overrides visitFile:
   takes path and attributes, compiles .clj files,
   and returns FileVisitResult/CONTINUE"
  (proxy [SimpleFileVisitor]
         []
         (visitFile [path attributes]
           (let [file-path   (.toFile path)
                 string-path (.toString path)]
             (if (.isFile file-path)
                 (if (or (.endsWith string-path ".cljs")
                         (.endsWith string-path ".cljc"))
                     (let [relative-path         (.relativize source-path path)
                           relative-string       (.toString relative-path)
                           dot-clj-index         (.indexOf relative-string ".clj")
                           without-suffix        (.substring relative-string 0 dot-clj-index)
                           ;; standardizing windows systems
                           forward-slash         (.replaceAll without-suffix "\\\\" "/")
                           underscores-to-dashes (.replaceAll forward-slash "_" "-")
                           source-namespace      (.replaceAll underscores-to-dashes "/" ".")]
                       (swap! cljs-paths conj forward-slash)))))
           FileVisitResult/CONTINUE)))

;; Walk source folder tree and compile Clojure source files.
(Files/walkFileTree source-path visitor)

;; Compile cljs files
(apply m/-main (apply conj *command-line-args* @cljs-paths))

