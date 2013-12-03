class SystemInfoController < ActionController::Base

  def index
    @system_info = SystemInfo.new()
    @system_info.info_date = DateTime.current
    @system_info.images = Image.all
  end

end