import FirebaseDatabase

class FirebaseApi {
    
    let db = Database.database()

    func getTopics(onTopics: @escaping (String?) -> Void) {
        get(key: "topics") { snapshot in
            let topics = snapshot?.toTopics()
            let json = topics?.toTopicsEcoded()
            onTopics(json)
        }
    }
    
    private func get(key: String, onResult: @escaping (DataSnapshot?) -> Void) {
        db.reference().child(key).observeSingleEvent(of: .value, with: { snapshot in
            onResult(snapshot)
        })
    }
}
