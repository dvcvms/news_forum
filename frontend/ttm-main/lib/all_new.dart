import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:trpp_proj/news.dart';
// import 'package:flutter/services.dart';
import 'package:trpp_proj/one_news.dart';

class AllNews extends StatefulWidget {
  final String? value;
  const AllNews({required this.value, super.key});
  @override
  State<AllNews> createState() => _AllNewsState();
}

class _AllNewsState extends State<AllNews> {
  List<News> news = [];

  @override
  void initState() {
    getData();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
        future: getData(),
        builder: (context, snapshot) {
          print(snapshot.connectionState);
          print(snapshot.hasData);
          print(snapshot.data);
          switch (snapshot.connectionState) {
            case ConnectionState.done:
              return news.isNotEmpty
              
                  ? Column(
                      children: [
                        ...news.map(
                          (e) => Padding(
                            padding: const EdgeInsets.only(top: 10, bottom: 10),
                            child: Container(
                              color: Colors.amber,
                              width: MediaQuery.of(context).size.width * 0.6,
                              child: OneNew(news: e),
                            ),
                          ),
                        )
                      ],
                    )
                  : const Center(
                      child: Text(
                        '404 NOT FOUND',
                        style: TextStyle(
                            fontSize: 64, fontWeight: FontWeight.bold),
                      ),
                    );
            default:
              return const CircularProgressIndicator();
          }
        });
  }

  final Dio _dio = Dio();

  getData() async {
      print('value: ${widget.value}');
    try {
      // _dio.post(
      //   "http://127.0.0.1:8080",
      // );
      // final response = await rootBundle.loadString("pac.json");
    
      String url = widget.value!.isEmpty
          ? 'http://localhost:8080/post/get'
          : "http://localhost:8080/post/getByCourseOrGroup/${Uri.encodeFull(widget.value!)}";
      final response = await _dio.get(url);
      var data = response.data;
      // news = newsFromJson(response);
      print(news);
      news = data.map<News>((news) => News.fromJson(news)).toList();
    } on DioError catch (e) {
      print(e);
    }
    return news;
  }
}
