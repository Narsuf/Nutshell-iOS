import FirebaseDatabase

class FirebaseApi {
    
    let db = Database.database()

    func getTopics(action: @escaping (String?) -> Void) {
        get(key: "topics") { snapshot in
            let topics = snapshot?.toTopics()
            let json = topics?.toTopicsEcoded()
            action(json)
        }
    }
    
    private func get(key: String, action: @escaping (DataSnapshot?) -> Void) {
        db.reference().child(key).observeSingleEvent(of: .value, with: { snapshot in
            action(snapshot)
        })
    }
}
