import SwiftUI
import Firebase
import ComposeApp

@main
struct iOSApp: App {
    
    init() {
        FirebaseApp.configure()
        AppKt.doInitKoin(ds: DataSourceImpl())
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
