import FirebaseDatabase

extension DataSnapshot {
    func toTopics() -> TopicsRaw {
        var topics: [TopicRaw] = []
        
        children.forEach { child in
            let dataSnapshot = child as? DataSnapshot
            
            if let topic = dataSnapshot?.toTopic() {
                topics.append(topic)
            }
        }
        
        return TopicsRaw(items: topics)
    }
    
    func toTopic() -> TopicRaw? {
        guard let topic = value as? NSDictionary else { return nil }
        guard let key = topic["key"] as? String else { return nil }
        guard let title = topic["title"] as? String else { return nil }
        guard let imageUrl = topic["imageUrl"] as? String else { return nil }

        return TopicRaw(key: key, title: title, imageUrl: imageUrl)
    }
}

extension TopicsRaw {
    func toTopicsEcoded() -> String? {
        let encoder = JSONEncoder()
        encoder.outputFormatting = [.prettyPrinted, .withoutEscapingSlashes]
        guard let jsonData = try? encoder.encode(self) else { return nil }
        guard let jsonString = String(data: jsonData, encoding: .utf8) else { return nil }
        return jsonString
    }
}
