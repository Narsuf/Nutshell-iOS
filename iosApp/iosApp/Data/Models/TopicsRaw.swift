struct TopicRaw {
    let key: String
    let title: String
    let imageUrl: String

    init(key: String = "", title: String = "", imageUrl: String = "") {
        self.key = key
        self.title = title
        self.imageUrl = imageUrl
    }
}
