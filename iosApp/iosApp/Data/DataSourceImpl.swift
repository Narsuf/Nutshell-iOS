import ComposeApp

class DataSourceImpl: NSObject, DataSource {

    let firebaseApi = FirebaseApi()
    
    func getTopics(onTopics: @escaping (String?) -> Void) {
        firebaseApi.getTopics() { json in
            onTopics(json)
        }
    }
}
