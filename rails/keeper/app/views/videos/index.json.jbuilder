json.array!(@videos) do |video|
  json.extract! video, :file_name, :format, :duration
  json.url video_url(video, format: :json)
end
