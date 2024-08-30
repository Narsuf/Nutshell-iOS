import SwiftUI
import Firebase
import ComposeApp

@main
struct iOSApp: App {
    
    init() {
        FirebaseApp.configure()
        initCallbacks()
    }
    
    func initCallbacks() {
        let firebaseApi = FirebaseApi()
        
        SwiftInterfaceKt.getTopics = {
            firebaseApi.getTopics() { json in
                SwiftInterfaceKt.onTopics(json)
            }
        }
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
