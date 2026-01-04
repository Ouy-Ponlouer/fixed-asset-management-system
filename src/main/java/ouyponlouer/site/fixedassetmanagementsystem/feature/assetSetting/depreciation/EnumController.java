package ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.depreciation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ouyponlouer.site.fixedassetmanagementsystem.base.DepreciationCycle;
import ouyponlouer.site.fixedassetmanagementsystem.base.DepreciationMethod;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.depreciation.dto.EnumOption;
import ouyponlouer.site.fixedassetmanagementsystem.feature.assetSetting.depreciation.dto.DepreciationOptionsResponse;
import java.util.stream.Stream;
@RestController
@RequestMapping("/api/v1/enums")
@RequiredArgsConstructor
public class EnumController {

    @GetMapping("/depreciation-options")
    public DepreciationOptionsResponse getDepreciationOptions() {
        var depreciation_methods = Stream.of(DepreciationMethod.values())
                .map(e -> new EnumOption( formatLabel(e.name()),e.name()))
                .toList();

        var depreciation_cycles = Stream.of(DepreciationCycle.values())
                .map(e -> new EnumOption(formatLabel(e.name()),e.name()))
                .toList();

        return new DepreciationOptionsResponse(depreciation_methods, depreciation_cycles);
    }

    private String formatLabel(String name) {
        return name.replace("_", " ")
                .toLowerCase()
                .replaceFirst("^.", String.valueOf(name.charAt(0)).toUpperCase());
    }
}
